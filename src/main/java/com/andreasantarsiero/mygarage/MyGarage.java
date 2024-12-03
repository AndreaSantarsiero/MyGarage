package com.andreasantarsiero.mygarage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.andreasantarsiero.mygarage.persistence.*;
import com.andreasantarsiero.mygarage.service.*;



public class MyGarage{
    public static void main(String[] args){
        //inizializzazione MyGarage
        Garage garage = new Garage();
        Menu menu = new Menu();
        Scanner scanner = menu.getScanner();
        int scelta = 0;
        aggiungiAccountTest(garage);

        
        //menu principale
        do{
            menu.showPrincipale();
            scelta = menu.getScelta();

            switch(scelta){
                case 1:
                    menu.areaPersonale(garage);
                    break;
                case 2:
                    menu.registrati(garage);
                    break;
                case 3:
                    System.out.println("Uscita dal programma...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
            
        }while(scelta != 3);
    }


    private static void aggiungiAccountTest(Garage garage){
        garage.aggiungiCliente(new Cliente("Cliente", "Prova", LocalDate.parse("2024-11-11", DateTimeFormatter.ISO_LOCAL_DATE), "via Tizio Caio 31", "Valencia", 46011, "clienteprova", "clienteprova00@example.com", "1234"));
        garage.aggiungiMeccanico(new Meccanico("Meccanico", "Prova", LocalDate.parse("2024-11-11", DateTimeFormatter.ISO_LOCAL_DATE), "via Peppino Impastato 14", "Valencia", 46011, "meccanicoprova", "meccanicoprova00@example.com", "1234", "gommista", 5, ""));
    }
}