package ClassPackage;

import java.time.LocalDate;



public class Meccanico extends Utente{
    //attributi
    private String qualifica;
    private int anniEsperienza;
    private String note;


    //costruttore
    public Meccanico(){}
    
    public Meccanico(int id, String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, String cap,
                     String nomeUtente, String email, String password, String qualifica, int anniEsperienza, String note){
        super(id, nome, cognome, dataDiNascita, indirizzo, provincia, cap, nomeUtente, email, password);
        this.qualifica = qualifica;
        this.anniEsperienza = anniEsperienza;
        this.note = note;
    }


    //metodi getter
    public String getQualifica(){
        return qualifica;
    }

    public int getAnniEsperienza(){
        return anniEsperienza;
    }

    public String getNote(){
        return note;
    }


    //metodi setter
    public void setQualifica(String qualifica){
        this.qualifica = qualifica;
    }

    public void setAnniEsperienza(int anniEsperienza){
        this.anniEsperienza = anniEsperienza;
    }

    public void setNote(String note){
        this.note = note;
    }


    //rappresentazione meccanico come stringa
    @Override
    public String toString(){
        return "Meccanico{" +
                "Qualifica: '" + qualifica + '\'' +
                ", Anni di Esperienza: " + anniEsperienza +
                ", Note: '" + note + '\'' +
                ", " + super.toString() +
                '}';
    }
}
