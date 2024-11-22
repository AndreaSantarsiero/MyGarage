package com.andreasantarsiero.mygarage.classpackage;

import java.util.ArrayList;
import java.util.List;

public class Macchina{
    //attributi
    private int id;
    private String marca;
    private String modello;
    private int anno;
    private int numeroPorte;
    private Cliente proprietario;
    private List<Appuntamento> appuntamenti;


    //costruttore
    public Macchina(){
        this.appuntamenti = new ArrayList<>();
    }
    
    public Macchina(int id, String marca, String modello, int anno, int numeroPorte, Cliente proprietario){
        this.id = id;
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.numeroPorte = numeroPorte;
        this.proprietario = proprietario;
        this.appuntamenti = new ArrayList<>();
    }


    //metodi getter
    public int getId(){
        return id;
    }

    public String getMarca(){
        return marca;
    }

    public String getModello(){
        return modello;
    }

    public int getAnno(){
        return anno;
    }

    public int getNumeroPorte(){
        return numeroPorte;
    }

    public Cliente getProprietario(){
        return proprietario;
    }

    public List<Appuntamento> getListaAppuntamenti(){
        return appuntamenti;
    }


    //metodi setter
    public void setId(int id){
        this.id = id;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModello(String modello){
        this.modello = modello;
    }

    public void setAnno(int anno){
        this.anno = anno;
    }

    public void setNumeroPorte(int numeroPorte){
        this.numeroPorte = numeroPorte;
    }

    public void setProprietario(Cliente proprietario){
        this.proprietario = proprietario;
    }


    //metodi gestione appuntamenti
    public void aggiungiAppuntamento(Appuntamento appuntamento){
        this.appuntamenti.add(appuntamento);
    }

    public void rimuoviAppuntamento(Appuntamento appuntamento){
        this.appuntamenti.remove(appuntamento);
    }


    //rappresentazione macchina come stringa
    @Override
    public String toString(){
        return "Macchina{" +
                "ID: " + id +
                ", Marca: '" + marca + '\'' +
                ", Modello: '" + modello + '\'' +
                ", Anno: " + anno +
                ", Numero Porte: " + numeroPorte +
                ", Proprietario: " + proprietario.getNome() + " " + proprietario.getCognome() +
                '}';
    }

    public String mostraInfoMacchina(){
        return marca + " " + modello + " del " + anno + " "  + numeroPorte + " porte";
    }

    public String mostraIdEInfoMacchina(){
        return "[ID: " + id + "] " + marca + " " + modello + " del " + anno + " "  + numeroPorte + " porte";
    }
}
