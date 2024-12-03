package com.andreasantarsiero.mygarage.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.andreasantarsiero.mygarage.persistence.*;



public class Menu{
    //attributi
    private int scelta;
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

    public int getScelta(){
        try{
            scelta = scanner.nextInt();
            scanner.nextLine();
        } 
        catch(InputMismatchException e){
            scelta = -1;
            scanner.nextLine();
        } 
        return scelta;
    }
    


    public void areaPersonale(Garage garage){
        System.out.print("Inserisci il dominio (cliente/meccanico): ");
        String dominio = scanner.nextLine();
        System.out.print("Inserisci nome utente: ");
        String username = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String password = scanner.nextLine();

        if(dominio.equals("cliente") && garage.loginCliente(username, password)){
            Cliente cliente = garage.getCliente(username, password);
            menuCliente(cliente, garage);
        }

        else if(dominio.equals("meccanico") && garage.loginMeccanico(username, password)){
            Meccanico meccanico = garage.getMeccanico(username, password);
            System.out.println("Bentornato " + meccanico.getNome());
        }

        else{
            System.out.println("Login errato, riprova");
        }
    }



    public void menuCliente(Cliente cliente, Garage garage){
        boolean continua = true;
        do{
            System.out.println("Bentornato " + cliente.getNome());
            System.out.println("1. Le mie macchine");
            System.out.println("2. Aggiungi una nuova macchina");
            System.out.println("3. Rimuovi una macchina esistente");
            System.out.println("4. I miei appuntamenti");
            System.out.println("5. Prenota un appuntamento dal meccanico");
            System.out.println("6. Disdici un appuntamento dal meccanico");
            System.out.println("7. Uscire");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch(scelta){
                case 1:
                    cliente.mostraMacchine();
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 2:
                    cliente.aggiungiNuovaMacchina(scanner, id);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 3:
                    cliente.rimuoviMacchinaEsistente(scanner);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 4:
                    cliente.mostraAppuntamenti();
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 5:
                    cliente.prenotaNuovoAppuntamento(scanner, id, garage);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 6:
                    cliente.disdiciAppuntamentoEsistente(scanner);
                    System.out.println("\nPremi Invio per tornare al menu...");
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("A presto!");
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }
        }while(continua);
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
            scelta = scanner.nextInt();
            scanner.nextLine();

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



    private LocalDate chiediData(String msg){
        LocalDate data = null;
        boolean validInput = false;

        while(!validInput){
            System.out.print(msg);
            String input = scanner.nextLine();
            try{
                data = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
                validInput = true;
            }catch(DateTimeParseException e){
                System.out.println("Formato data non valido. Riprova.");
            }
        }
        return data;
    }


    private String chiediEmail(){
        String email;

        while(true){
            email = scanner.nextLine();
            if(isValidEmail(email)){
                break;      //ESCO DAL WHILE SOLO SE L'UTENTE INMSERISCE UNA MAIL DI UN FORMATO CORRETTO
            }
            else{
                System.out.print("Formato email non valido. Riprova: ");
            }
        }
        return email;
    }


    private boolean isValidEmail(String email){
        String emailRegEx = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zAZ]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegEx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



    private Cliente registraCliente(){
        Cliente cliente = new Cliente();
        
        System.out.print("- nome: ");
        cliente.setNome(scanner.nextLine());
        System.out.print("- cognome: ");
        cliente.setCognome(scanner.nextLine());
        cliente.setDataDiNascita(chiediData("- data di nascita (yyyy-MM-dd): "));
        System.out.print("- indirizzo: ");
        cliente.setIndirizzo(scanner.nextLine());
        System.out.print("- provincia: ");
        cliente.setProvincia(scanner.nextLine());
        System.out.print("- CAP: ");
        cliente.setCap(scanner.nextLine());

        System.out.print("- nome utente: ");
        cliente.setNomeUtente(scanner.nextLine());
        System.out.print("- email: ");
        cliente.setEmail(chiediEmail());
        cliente.createPassword(scanner, "- password: ");

        System.out.println("Registrazione completata con successo!");
        return cliente;
    }



    private Meccanico registraMeccanico(){
        Meccanico meccanico = new Meccanico();
    
        System.out.print("- nome: ");
        meccanico.setNome(scanner.nextLine());
        System.out.print("- cognome: ");
        meccanico.setCognome(scanner.nextLine());
        meccanico.setDataDiNascita(chiediData("- data di nascita (yyyy-MM-dd): "));
        System.out.print("- indirizzo: ");
        meccanico.setIndirizzo(scanner.nextLine());
        System.out.print("- provincia: ");
        meccanico.setProvincia(scanner.nextLine());
        System.out.print("- CAP: ");
        meccanico.setCap(scanner.nextLine());
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

        System.out.print("- nome utente: ");
        meccanico.setNomeUtente(scanner.nextLine());
        System.out.print("- email: ");
        meccanico.setEmail(chiediEmail());
        meccanico.createPassword(scanner, "- password: ");

        System.out.println("Registrazione completata con successo!");
        return meccanico;
    }
}