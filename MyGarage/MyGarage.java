import java.util.Scanner;

import ClassPackage.*;



public class MyGarage{
    public static void main(String[] args){
        //inizializzazione MyGarage
        Garage garage = new Garage();
        Menu menu = new Menu();
        Scanner scanner = menu.getScanner();
        int scelta=0;

        
        do{
            scelta = menu.showMenuPrincipale();

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
    
        } while (scelta != 3);
    }    
}