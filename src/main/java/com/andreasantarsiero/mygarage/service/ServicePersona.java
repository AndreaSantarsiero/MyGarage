package com.andreasantarsiero.mygarage.service;

import java.util.Scanner;
import com.andreasantarsiero.mygarage.persistence.*;



public class ServicePersona{
    public static void registraDati(Persona persona, Scanner scanner){
        System.out.print("- nome: ");
        persona.setNome(scanner.nextLine());
        System.out.print("- cognome: ");
        persona.setCognome(scanner.nextLine());
        persona.setDataDiNascita(Utils.chiediData("- data di nascita (yyyy-MM-dd): ", scanner));
        System.out.print("- indirizzo: ");
        persona.setIndirizzo(scanner.nextLine());
        System.out.print("- provincia: ");
        persona.setProvincia(scanner.nextLine());
        System.out.print("- CAP: ");
        persona.setCap(scanner.nextInt());
        scanner.nextLine();
    }
}
