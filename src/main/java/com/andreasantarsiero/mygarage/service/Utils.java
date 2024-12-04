package com.andreasantarsiero.mygarage.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;



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
            if(ServiceUtente.isValidEmail(email)){
                break;      //ESCO DAL WHILE SOLO SE L'UTENTE INMSERISCE UNA MAIL DI UN FORMATO CORRETTO
            }
            else{
                System.out.print("Formato email non valido. Riprova: ");
            }
        }
        return email;
    }
}
