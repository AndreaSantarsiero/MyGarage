package com.andreasantarsiero.mygarage.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Meccanico extends Utente{
    //attributi
    private String qualifica;
    private int anniEsperienza;
    private String note;
    private List<Appuntamento> appuntamenti;


    //costruttore
    public Meccanico(){
        this.appuntamenti = new ArrayList<>();
    }
    
    public Meccanico(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, int cap,
                     String nomeUtente, String email, String password, String qualifica, int anniEsperienza, String note){
        super(nome, cognome, dataDiNascita, indirizzo, provincia, cap, nomeUtente, email, password);
        this.qualifica = qualifica;
        this.anniEsperienza = anniEsperienza;
        this.note = note;
        this.appuntamenti = new ArrayList<>();
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


    //metodi gestione liste
    public List<Appuntamento> getAppuntamenti(){
        return appuntamenti;
    }

    public void aggiungiAppuntamento(Appuntamento appuntamento){
        this.appuntamenti.add(appuntamento);
    }

    public void rimuoviAppuntamento(Appuntamento appuntamento){
        this.appuntamenti.remove(appuntamento);
    }

    
    //rappresentazione meccanico come stringa
    @Override
    public String toString(){
        return "Meccanico" +
                " {Qualifica: " + qualifica + 
                ", Anni di Esperienza: " + anniEsperienza +
                ", Note: '" + note + 
                ", " + super.toString() +
                '}';
    }
}
