import java.time.LocalDate;
import java.util.Scanner;

import ClassPackage.*;



public class MyGarage{
    public static void main(String[] args){
        //inizializzazione MyGarage
        Garage garage = new Garage();
        Id id = new Id();
        Scanner scanner = new Scanner(System.in);
        int scelta;

        

        do{
            System.out.println("Menu:");
            System.out.println("1. Area Personale");
            System.out.println("2. Registrati");
            System.out.println("3. Esci");
            System.out.print("Seleziona un'opzione: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch(scelta){
                case 1:
                    areaPersonale(scanner, garage);
                    break;
                case 2:
                    registrati(scanner, garage);
                    break;
                case 3:
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }

        } while (scelta != 3);

        scanner.close();
    }





    private static void areaPersonale(Scanner scanner, Garage garage){
        System.out.print("Inserisci il dominio (cliente/meccanico): ");
        String dominio = scanner.nextLine();
        System.out.print("Inserisci nome utente o email: ");
        String username = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String password = scanner.nextLine();

        if(dominio.equals("cliente") && Garage.loginCliente(username, password)){
            Cliente cliente = Garage.getCliente(username, password);
            System.out.println("Bentornato " + cliente.getNome());
        }

        else if(dominio.equals("meccanico") && Garage.loginMeccanico(username, password)){
            Meccanico meccanico = Garage.getMeccanico(username, password);
            System.out.println("Bentornato " + meccanico.getNome());
        }

        else{
            System.out.println("Login errato, riprova");
        }
    }



    private static void registrati(Scanner scanner, Garage garage){
        int scelta;


        do{
            System.out.println("Seleziona il tipo di account da creare:");
            System.out.println("1. Cliente");
            System.out.println("2. Meccanico");
            System.out.println("3. Torna al menu principale");
            System.out.print("Inserisci la tua scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline rimasto

            switch(scelta){
                case 1:
                    System.out.println("Registrazione effettuata come Cliente.");
                    break;
                case 2:
                    System.out.println("Registrazione effettuata come Meccanico.");
                    break;
                case 3:
                break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }

        }while(scelta != 3);
        
    }
}