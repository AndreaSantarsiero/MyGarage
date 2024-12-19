package com.andreasantarsiero.mygarage.service;

import com.andreasantarsiero.mygarage.persistence.*;



public class UtenteService extends PersonaService{
    public static boolean isPasswordAlreadyCreated(Utente utente){
        return utente.isPasswordAlreadyCreated();
    }


    public static boolean setFirstPassword(Utente utente, String password){
        if(utente.isPasswordAlreadyCreated() == false){
            utente.setFirstPassword(password);
            return true;
        }
        else{
            return false;
        }
    }


    public static boolean changePassword(Utente utente, String oldPassword, String newPassword){
        return utente.changePassword(oldPassword, newPassword);
    }


    public static boolean checkPasswordKnowledge(Utente utente, String password){
        return utente.checkPassword(password);
    }
}
