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
            if(cliente != null){
                menuCliente(cliente, garage);
            }
            else{
                System.out.println("Username non trovato.");
            }
        }

        else if(dominio.equals("meccanico") && GarageService.loginMeccanico(garage, username, password)){
            Meccanico meccanico = GarageService.getMeccanico(garage, username, password);
            if(meccanico != null){
                System.out.println("Bentornato " + meccanico.getNome());
            }
            else{
                System.out.println("Username non trovato.");
            }
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
                    ClienteUserInterface.mostraMacchine(cliente);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 2:
                    ClienteUserInterface.aggiungiNuovaMacchina(cliente, scanner, id);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 3:
                    ClienteUserInterface.rimuoviMacchinaEsistente(cliente, scanner);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 4:
                    ClienteUserInterface.mostraAppuntamenti(cliente);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 5:
                    ClienteUserInterface.prenotaNuovoAppuntamento(cliente, scanner, id, garage);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 6:
                    ClienteUserInterface.disdiciAppuntamentoEsistente(cliente, scanner);
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
        
        PersonaUserInterface.registraDati(cliente, scanner);
        UtenteUserInterface.registraDati(cliente, scanner);
        ClienteUserInterface.registraDati(cliente, scanner);

        System.out.println("Registrazione completata con successo!");
        return cliente;
    }


    private Meccanico registraMeccanico(){
        Meccanico meccanico = new Meccanico();
    
        PersonaUserInterface.registraDati(meccanico, scanner);
        UtenteUserInterface.registraDati(meccanico, scanner);
        MeccanicoUserInterface.registraDati(meccanico, scanner);

        System.out.println("Registrazione completata con successo!");
        return meccanico;
    }
}