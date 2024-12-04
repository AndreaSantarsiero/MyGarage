package com.andreasantarsiero.mygarage.persistence;

import java.time.LocalDate;
import java.util.Scanner;



public class Utente extends Persona{
    //attributi
    private String nomeUtente;
    private String email;
    private String password;


    //costruttore
    public Utente(){
        inizializePassword();
    }
    
    public Utente(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, int cap,
                  String nomeUtente, String email, String password){
        super(nome, cognome, dataDiNascita, indirizzo, provincia, cap);
        this.nomeUtente = nomeUtente;
        this.email = email;
        this.password = password;
    }


    //metodi getter
    public String getNomeUtente(){
        return nomeUtente;
    }

    public String getEmail(){
        return email;
    }


    //metodi setter
    public void setNomeUtente(String nomeUtente){
        this.nomeUtente = nomeUtente;
    }

    public void setEmail(String email){
        this.email = email;
    }


    //metodi gestione password
    private void inizializePassword(){
        this.password = "";
    }
    
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    private boolean controllaRequisitiPassword(String newPassword){
        if(newPassword.length() >= 8){
            return true;
        }
        else{
            System.out.println("La nuova password non è valida. Deve avere almeno 8 caratteri.");
            return false;
        }
    }


    private boolean askPasswordKnowledge(Scanner scanner){
        String password;
        int tentativi = 0;
        final int maxTentativi = 3;

        while(tentativi < maxTentativi){
            System.out.print("Inserisci la vecchia password: ");
            password = scanner.nextLine();
    
            if (checkPassword(password) == false){
                tentativi++;
                if(tentativi < maxTentativi){
                    System.out.println("Password errata. Riprova.");
                }
                else{
                    System.out.println("Hai superato il numero massimo di tentativi.");
                    return false;
                }
            }
        }

        return true;
    }


    private void askNewPassword(Scanner scanner){
        String newPassword;
        boolean passwordApproved;

        do{
            System.out.print("Inserisci la nuova password: ");
            newPassword = scanner.nextLine();
            passwordApproved = controllaRequisitiPassword(newPassword);

            if(passwordApproved == true){
                this.password = newPassword;
                System.out.println("Password cambiata con successo.");
            }
        }while(passwordApproved == false);
    }


    public boolean changePassword(Scanner scanner){

        if(askPasswordKnowledge(scanner) == true){
            askNewPassword(scanner);
            return true;
        }
        else{
            return false;
        }
    }
    

    public void createPassword(Scanner scanner, String msg){
        String newPassword;
        boolean passwordApproved;

        if(password.equals("")){
            do{
                System.out.print(msg);
                newPassword = scanner.nextLine();
                passwordApproved = controllaRequisitiPassword(newPassword);

                if(passwordApproved == true){
                    this.password = newPassword;
                }
            }while(passwordApproved == false);
        }
        else{
            System.out.println("Errore: la password è già stata creata");
        }
    }

    
    //rappresentazione utente come stringa
    @Override
    public String toString(){
        return "Utente" +
                " {Nome Utente: " + nomeUtente + 
                ", Email: " + email + 
                ", " + super.toString() + 
                '}';
    }
}
