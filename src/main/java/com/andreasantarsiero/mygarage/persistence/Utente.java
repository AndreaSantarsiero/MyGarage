package com.andreasantarsiero.mygarage.persistence;

import java.time.LocalDate;



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

    public boolean isPasswordAlreadyCreated(){
        return !(this.password.equals(""));
    }


    public boolean setFirstPassword(String password){
        if(isPasswordAlreadyCreated() == false){
            this.password = password;
            return true;
        }
        else{
            return false;
        }
    }


    public boolean changePassword(String oldPassword, String newPassword){
        if(checkPassword(oldPassword) == true){
            this.password = newPassword;
            return true;
        }
        else{
            return false;
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
