package com.andreasantarsiero.mygarage.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.andreasantarsiero.mygarage.persistence.*;
import com.andreasantarsiero.mygarage.utils.*;



public class UtenteService{
    public static void registraDati(Utente utente, Scanner scanner){
        System.out.print("- nome utente: ");
        utente.setNomeUtente(scanner.nextLine());
        System.out.print("- email: ");
        utente.setEmail(Utils.chiediEmail(scanner));
        utente.createPassword(scanner, "- password: ");
    }

    
    public static boolean isValidEmail(String email){
        String emailRegEx = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zAZ]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegEx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
