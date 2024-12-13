package com.andreasantarsiero.mygarage.userInterface;

import java.util.Scanner;
import com.andreasantarsiero.mygarage.persistence.Meccanico;



public class MeccanicoUserInterface{
    public static void registraDati(Meccanico meccanico, Scanner scanner){
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
    }
}
