package com.andreasantarsiero.mygarage.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Utils{
    public static int chiediIntero(Scanner scanner){
        int scelta; 

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


    public static LocalDate chiediData(String msg, Scanner scanner){
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


    public static String chiediEmail(Scanner scanner){
        String email;

        while(true){
            email = scanner.nextLine();
            if(checkEmailFormat(email)){
                break;      //ESCO DAL WHILE SOLO SE L'UTENTE INMSERISCE UNA MAIL DI UN FORMATO CORRETTO
            }
            else{
                System.out.print("Formato email non valido. Riprova: ");
            }
        }
        return email;
    }


    public static boolean checkEmailFormat(String email){
        String emailRegEx = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zAZ]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegEx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
