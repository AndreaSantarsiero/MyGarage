package ClassPackage;

import java.time.LocalDate;



public class Cliente extends Utente{
    //attributi
    private int puntiFedelta;


    //costruttore
    public Cliente(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, String cap,
                   String nomeUtente, String email, String password){
        super(nome, cognome, dataDiNascita, indirizzo, provincia, cap, nomeUtente, email, password);
        this.puntiFedelta = 0;
    }


    //metodi getter
    public int getPuntiFedelta(){
        return puntiFedelta;
    }


    //metodi setter
    public void setPuntiFedelta(int puntiFedelta){
        this.puntiFedelta = puntiFedelta;
    }


    //rappresentazione cliente come stringa
    @Override
    public String toString(){
        return "Cliente{" +
                "Punti Fedeltà: " + puntiFedelta +
                ", " + super.toString() +
                '}';
    }
}
