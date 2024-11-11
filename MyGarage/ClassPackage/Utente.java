package ClassPackage;

import java.time.LocalDate;
import java.util.Scanner;



public class Utente extends Persona{
    //attributi
    private String nomeUtente;
    private String email;
    private String password;


    //costruttore
    public Utente(){}
    
    public Utente(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, String cap,
                  String nomeUtente, String email, String password){
        super(nome, cognome, dataDiNascita, indirizzo, provincia, cap);
        this.nomeUtente = nomeUtente;
        this.email = email;
        this.password = password;
    }


    //metodi getter
    public String getNomeUtente(){
        return nomeUtente;
    }

    public String getEmail(){
        return email;
    }


    //metodi setter
    public void setNomeUtente(String nomeUtente){
        this.nomeUtente = nomeUtente;
    }

    public void setEmail(String email){
        this.email = email;
    }


    //metodi gestione password
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }


    private boolean controllaRequisitiPassword(String newPassword){
        return newPassword.length() >= 8;
    }



    public boolean changePassword(Scanner scanner){
        String oldPassword;
        String newPassword;
        int tentativi = 0;
        final int maxTentativi = 3;
    
        //verifico che l'utente conosce la vecchia password (massimo 3 tentativi)
        while(tentativi < maxTentativi){
            System.out.print("Inserisci la vecchia password: ");
            oldPassword = scanner.nextLine();
    
            if (checkPassword(oldPassword)){
                break;
            }
            else {
                tentativi++;
                if(tentativi < maxTentativi){
                    System.out.println("Password errata. Riprova.");
                }
                else{
                    System.out.println("Hai superato il numero massimo di tentativi.");
                    return false;     //L'UTENTE NON CONOSCE LA PASSWORD VECCHIA
                }
            }
        }
    
        //imposto nuova password
        do{
            System.out.print("Inserisci la nuova password: ");
            newPassword = scanner.nextLine();

            if(controllaRequisitiPassword(newPassword)){
                this.password = newPassword;
                System.out.println("Password cambiata con successo.");
            }
            else{
                System.out.println("La nuova password non è valida. Deve avere almeno 8 caratteri.");
            }
        }while(!controllaRequisitiPassword(newPassword));

        return true;     //L'UTENTE HA CAMBIATO LA PASSWORD CON SUCCESSO
    }
    
    

    public void createPassword(Scanner scanner, String msg){
        String newPassword;

        if(password.equals("")){
            do{
                System.out.print(msg);
                newPassword = scanner.nextLine();

                if(controllaRequisitiPassword(newPassword)){
                    this.password = newPassword;
                }
                else{
                    System.out.println("La nuova password non è valida. Deve avere almeno 8 caratteri.");
                }
            }while(!controllaRequisitiPassword(newPassword));
        }
        else{
            System.out.println("Errore: la password è già stata creata");
        }
    }



    //rappresentazione utente come stringa
    @Override
    public String toString(){
        return "Utente{" +
                "Nome Utente: '" + nomeUtente + '\'' +
                ", Email: '" + email + '\'' +
                ", " + super.toString() + 
                '}';
    }
}
