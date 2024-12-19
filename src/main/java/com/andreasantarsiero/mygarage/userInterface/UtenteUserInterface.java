package com.andreasantarsiero.mygarage.userInterface;

import java.util.Scanner;
import com.andreasantarsiero.mygarage.persistence.*;
import com.andreasantarsiero.mygarage.service.*;
import com.andreasantarsiero.mygarage.utils.*;



public class UtenteUserInterface extends PersonaUserInterface{
    public static void registraDati(Utente utente, Scanner scanner){
        PersonaUserInterface.registraDati(utente, scanner);

        System.out.print("- nome utente: ");
        utente.setNomeUtente(scanner.nextLine());
        System.out.print("- email: ");
        utente.setEmail(Utils.chiediEmail(scanner));
        createPassword(utente, scanner);
    }


    /* private boolean askPasswordKnowledge(Utente utente, Scanner scanner, String msg){
        String password;
        int tentativi = 0;
        final int maxTentativi = 3;

        while(tentativi < maxTentativi){
            System.out.print(msg);
            password = scanner.nextLine();
    
            if (UtenteService.checkPasswordKnowledge(utente, password) == false){
                tentativi++;
                if(tentativi < maxTentativi){
                    System.out.println("Password errata. Riprova (" + (maxTentativi-tentativi) + " tentativi rimasti)");
                }
                else{
                    System.out.println("Hai superato il numero massimo di tentativi.");
                    return false;
                }
            }
        }

        //"Inserisci la nuova password: "
        //"Inserisci la vecchia password: "
        return true;
    } */



    private static String askNewPassword(Scanner scanner, String msg){
        String newPassword;

        do{
            System.out.print(msg);
            newPassword = scanner.nextLine();
        } while(checkPasswordComplexity(newPassword) == false);

        return newPassword;
    }
  
    

    public static void createPassword(Utente utente, Scanner scanner){

        if(UtenteService.isPasswordAlreadyCreated(utente) == false){
            UtenteService.setFirstPassword(utente, askNewPassword(scanner, "- password: "));
        }
        else{
            System.out.println("Errore: la password è già stata creata");
        }
    }

    
    public static boolean checkPasswordComplexity(String newPassword){
        if(newPassword.length() >= 8){
            return true;
        }
        else{
            System.out.println("La nuova password non è valida. Deve avere almeno 8 caratteri.");
            return false;
        }
    }
}
