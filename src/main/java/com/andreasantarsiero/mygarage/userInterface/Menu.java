package com.andreasantarsiero.mygarage.userInterface;

import java.util.Scanner;
import com.andreasantarsiero.mygarage.persistence.*;
import com.andreasantarsiero.mygarage.service.*;
import com.andreasantarsiero.mygarage.utils.*;



public class Menu{
    //attributi
    private Scanner scanner;
    private Id id;


    //costruttore
    public Menu(){
        scanner = new Scanner(System.in);
        id = new Id();
    }


    //metodi getter
    public Scanner getScanner(){
        return scanner;
    }


    //metodi menu secondari
    public void showPrincipale(){
        System.out.println("Menu:");
        System.out.println("1. Area Personale");
        System.out.println("2. Registrati");
        System.out.println("3. Esci");
        System.out.print("Seleziona un'opzione: ");
    }
    


    public void areaPersonale(Garage garage){
        System.out.print("Inserisci il dominio (cliente/meccanico): ");
        String dominio = scanner.nextLine();
        System.out.print("Inserisci nome utente: ");
        String username = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String password = scanner.nextLine();

        if(dominio.equals("cliente") && GarageService.loginCliente(garage, username, password)){
            Cliente cliente = GarageService.getCliente(garage, username, password);
            menuCliente(cliente, garage);
        }

        else if(dominio.equals("meccanico") && GarageService.loginMeccanico(garage, username, password)){
            Meccanico meccanico = GarageService.getMeccanico(garage, username, password);
            System.out.println("Bentornato " + meccanico.getNome());
        }

        else{
            System.out.println("Login errato, riprova");
        }
    }



    public void menuCliente(Cliente cliente, Garage garage){
        boolean showMenu = true;
        do{
            System.out.println("Bentornato " + cliente.getNome());
            System.out.println("1. Le mie macchine");
            System.out.println("2. Aggiungi una nuova macchina");
            System.out.println("3. Rimuovi una macchina esistente");
            System.out.println("4. I miei appuntamenti");
            System.out.println("5. Prenota un appuntamento dal meccanico");
            System.out.println("6. Disdici un appuntamento dal meccanico");
            System.out.println("7. Uscire");
            int scelta = Utils.chiediIntero(scanner);

            switch(scelta){
                case 1:
                    ClienteService.mostraMacchine(cliente);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 2:
                    ClienteService.aggiungiNuovaMacchina(cliente, scanner, id);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 3:
                    ClienteService.rimuoviMacchinaEsistente(cliente, scanner);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 4:
                    ClienteService.mostraAppuntamenti(cliente);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 5:
                    ClienteService.prenotaNuovoAppuntamento(cliente, scanner, id, garage);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 6:
                    ClienteService.disdiciAppuntamentoEsistente(cliente, scanner);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("A presto!");
                    showMenu = false;
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }
        }while(showMenu == true);
    }



    public void registrati(Garage garage){
        int scelta;
        boolean continua = true;

        do{
            System.out.println("Seleziona il tipo di account da creare:");
            System.out.println("1. Cliente");
            System.out.println("2. Meccanico");
            System.out.println("3. Torna al menu principale");
            System.out.print("Inserisci la tua scelta: ");
            scelta = Utils.chiediIntero(scanner);

            switch(scelta){
                case 1:
                    Cliente nuovoCliente = registraCliente();
                    garage.aggiungiCliente(nuovoCliente);
                    continua = false;
                    break;
                case 2:
                    Meccanico nuovoMeccanico = registraMeccanico();
                    garage.aggiungiMeccanico(nuovoMeccanico);
                    continua = false;
                    break;
                case 3:
                    continua = false;
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }

        }while(continua);
    }



    private Cliente registraCliente(){
        Cliente cliente = new Cliente();
        
        PersonaService.registraDati(cliente, scanner);
        UtenteService.registraDati(cliente, scanner);

        System.out.println("Registrazione completata con successo!");
        return cliente;
    }



    private Meccanico registraMeccanico(){
        Meccanico meccanico = new Meccanico();
    
        PersonaService.registraDati(meccanico, scanner);
        UtenteService.registraDati(meccanico, scanner);

        System.out.print("- qualifica: ");
        meccanico.setQualifica(scanner.nextLine());
        System.out.print("- anni di esperienza: ");

        while(true){
            try{
                int esperienza = Integer.parseInt(scanner.nextLine());
                meccanico.setAnniEsperienza(esperienza);
                break;  //ESCO DAL WHILE SOLO SE L'INPUT E' UN NUMERO
            }catch(NumberFormatException e){
                System.out.print("Errore: inserisci un numero valido per gli anni di esperienza: ");
            }
        }

        System.out.println("Registrazione completata con successo!");
        return meccanico;
    }
}