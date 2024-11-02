package ClassPackage;

import java.time.LocalDate;



public class Utente extends Persona{
    //attributi
    private String nomeUtente;
    private String email;
    private String password;


    //costruttore
    public Utente(){}
    
    public Utente(int id, String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, String cap,
                  String nomeUtente, String email, String password){
        super(id, nome, cognome, dataDiNascita, indirizzo, provincia, cap);
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
        if(this.password == password){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setPassword(){
        String oldPassword = "";
        String newPassword = "";

        //chiedo la vecchia password
        if(checkPassword(oldPassword) == false){
            //richiedo la password vecchia
            return false;   //dopo 3 tentativi
        }
        else{
            //chiedo la password nuova
            this.password = newPassword;
            return true;
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
