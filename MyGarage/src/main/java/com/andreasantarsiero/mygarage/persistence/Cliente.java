package com.andreasantarsiero.mygarage.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Cliente extends Utente{
    //attributi
    private int puntiFedelta;
    private List<Macchina> macchine;


    //costruttore
    public Cliente(){
        this.macchine = new ArrayList<>();
    }

    public Cliente(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, int cap,
                   String nomeUtente, String email, String password){
        super(nome, cognome, dataDiNascita, indirizzo, provincia, cap, nomeUtente, email, password);
        this.puntiFedelta = 0;
        this.macchine = new ArrayList<>();
    }


    //metodi getter
    public int getPuntiFedelta(){
        return puntiFedelta;
    }


    //metodi setter
    public void setPuntiFedelta(int puntiFedelta){
        this.puntiFedelta = puntiFedelta;
    }
    

    //metodi gestione liste
    public List<Macchina> getMacchine(){
        return macchine;
    }

    public void aggiungiMacchina(Macchina macchina){
        this.macchine.add(macchina);
    }

    public void rimuoviMacchina(Macchina macchina){
        this.macchine.remove(macchina);
    }


    //rappresentazione cliente come stringa
    @Override
    public String toString(){
        return "Cliente" +
                " {Punti Fedeltà: " + puntiFedelta +
                ", " + super.toString() +
                '}';
    }
}
