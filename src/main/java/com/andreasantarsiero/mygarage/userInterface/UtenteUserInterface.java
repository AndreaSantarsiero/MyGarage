package com.andreasantarsiero.mygarage.userInterface;

import java.util.Scanner;
import com.andreasantarsiero.mygarage.persistence.*;
import com.andreasantarsiero.mygarage.utils.*;



public class UtenteUserInterface{
    public static void registraDati(Utente utente, Scanner scanner){
        System.out.print("- nome utente: ");
        utente.setNomeUtente(scanner.nextLine());
        System.out.print("- email: ");
        utente.setEmail(Utils.chiediEmail(scanner));
        utente.createPassword(scanner, "- password: ");
    }
}
