package ClassPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class Menu{
    //attributi
    private int scelta;
    private Scanner scanner;
    //private Id id;


    //costruttore
    public Menu(){
        scanner = new Scanner(System.in);
        //id = new Id();
    }


    //metodi getter
    public Scanner getScanner(){
        return scanner;
    }


    public int showMenuPrincipale(){
        try{
            System.out.println("Menu:");
            System.out.println("1. Area Personale");
            System.out.println("2. Registrati");
            System.out.println("3. Esci");
            System.out.print("Seleziona un'opzione: ");
            scelta = scanner.nextInt();
            scanner.nextLine();
        } 
        catch(InputMismatchException e){
            scelta = -1;
            scanner.nextLine();
        } 
        
        return scelta;
    }
    


    public void areaPersonale(Garage garage){
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


    public void registrati(Garage garage){
        int scelta;


        do{
            System.out.println("Seleziona il tipo di account da creare:");
            System.out.println("1. Cliente");
            System.out.println("2. Meccanico");
            System.out.println("3. Torna al menu principale");
            System.out.print("Inserisci la tua scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch(scelta){
                case 1:
                    Cliente nuovoCliente = registraCliente();
                    garage.aggiungiCliente(nuovoCliente);
                    break;
                case 2:
                    Meccanico nuovoMeccanico = registraMeccanico();
                    garage.aggiungiMeccanico(nuovoMeccanico);
                    break;
                case 3:
                break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }

        }while(scelta != 3);
        
    }


    private LocalDate chiediData(String msg){
        LocalDate data = null;
        boolean validInput = false;
        while(!validInput){
            System.out.print(msg);
            String input = scanner.nextLine();
            try {
                data = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
                validInput = true; // Valid input received
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Riprova.");
            }
        }
        return data;
    }


    private Cliente registraCliente(){
        Cliente cliente = new Cliente();
        
        System.out.print("- nome: ");
        cliente.setNome(scanner.nextLine());
        System.out.print("- cognome: ");
        cliente.setCognome(scanner.nextLine());
        cliente.setDataDiNascita(chiediData("- data di nascita (yyyy-MM-dd): "));
        System.out.print("- indirizzo: ");
        cliente.setIndirizzo(scanner.nextLine());
        System.out.print("- provincia: ");
        cliente.setProvincia(scanner.nextLine());
        System.out.print("- CAP: ");
        cliente.setCap(scanner.nextLine());

        System.out.print("- nome utente: ");
        cliente.setNomeUtente(scanner.nextLine());
        System.out.print("- email: ");
        cliente.setEmail(scanner.nextLine());
        cliente.createPassword(scanner, "- password: ");

        System.out.println("Registrazione completata con successo!");
        return cliente;
    }


    private Meccanico registraMeccanico() {
        Meccanico meccanico = new Meccanico();
    
        System.out.print("- nome: ");
        meccanico.setNome(scanner.nextLine());
        System.out.print("- cognome: ");
        meccanico.setCognome(scanner.nextLine());
        meccanico.setDataDiNascita(chiediData("- data di nascita (yyyy-MM-dd): "));
        System.out.print("- indirizzo: ");
        meccanico.setIndirizzo(scanner.nextLine());
        System.out.print("- provincia: ");
        meccanico.setProvincia(scanner.nextLine());
        System.out.print("- CAP: ");
        meccanico.setCap(scanner.nextLine());
        System.out.print("- qualifica: ");
        meccanico.setQualifica(scanner.nextLine());

        System.out.print("- anni di esperienza: ");
        while (true) {
            try {
                int esperienza = Integer.parseInt(scanner.nextLine());
                meccanico.setAnniEsperienza(esperienza);
                break;  //ESCO DAL WHILE SOLO SE L'INPUT E' UN NUMERO
            } catch (NumberFormatException e) {
                System.out.print("Errore: inserisci un numero valido per gli anni di esperienza: ");
            }
        }

        System.out.print("- nome utente: ");
        meccanico.setNomeUtente(scanner.nextLine());
        System.out.print("- email: ");
        meccanico.setEmail(scanner.nextLine());
        meccanico.createPassword(scanner, "- password: ");

        System.out.println("Registrazione completata con successo!");
        return meccanico;
    }
}