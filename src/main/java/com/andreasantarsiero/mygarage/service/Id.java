package com.andreasantarsiero.mygarage.service;



public class Id{
    //attributi
    private int numeroMacchine;
    private int numeroAppuntamenti;


    //costruttore
    public Id(){
        this.numeroMacchine = 0;
        this.numeroAppuntamenti = 0;
    }


    //metodi createId (per inizializzare oggetti)
    public int createIdMacchina(){
        numeroMacchine++;
        return numeroMacchine;
    }

    public int createIdAppuntamento(){
        numeroAppuntamenti++;
        return numeroAppuntamenti;
    }
}

