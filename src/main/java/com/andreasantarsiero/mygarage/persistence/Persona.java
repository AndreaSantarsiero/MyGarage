package com.andreasantarsiero.mygarage.persistence;

import java.time.LocalDate;



public class Persona{
    //attributi
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String indirizzo;
    private String provincia;
    private int cap;


    //costruttore
    public Persona(){}

    public Persona(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, int cap){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.provincia = provincia;
        this.cap = cap;
    }


    //metodi getter
    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public LocalDate getDataDiNascita(){
        return dataDiNascita;
    }

    public String getIndirizzo(){
        return indirizzo;
    }

    public String getProvincia(){
        return provincia;
    }

    public int getCap(){
        return cap;
    }


    //metodi setter
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setDataDiNascita(LocalDate dataDiNascita){
        this.dataDiNascita = dataDiNascita;
    }

    public void setIndirizzo(String indirizzo){
        this.indirizzo = indirizzo;
    }

    public void setProvincia(String provincia){
        this.provincia = provincia;
    }

    public void setCap(int cap){
        this.cap = cap;
    }


    //rappresentazione persona come stringa
    @Override
    public String toString(){
        return "Persona" +
                " {Nome: " + nome + 
                ", Cognome: " + cognome + 
                ", Data di Nascita: " + dataDiNascita.toString() +
                ", Indirizzo: " + indirizzo + 
                ", Provincia: " + provincia + 
                ", CAP: " + cap + 
                '}';
    }
}
