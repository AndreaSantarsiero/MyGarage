package com.andreasantarsiero.mygarage.persistence;

import java.util.ArrayList;
import java.util.List;



public class Garage{
    //attributi
    private List<Meccanico> meccanici;
    private List<Cliente> clienti;


    //costruttore
    public Garage(){
        this.meccanici = new ArrayList<>();
        this.clienti = new ArrayList<>();
    }


    //metodi gestione liste
    public List<Meccanico> getMeccanici(){
        return meccanici;
    }

    public List<Cliente> getClienti(){
        return clienti;
    }

    public void aggiungiMeccanico(Meccanico meccanico){
        this.meccanici.add(meccanico);
    }

    public void aggiungiCliente(Cliente cliente){
        this.clienti.add(cliente);
    }

    public void rimuoviMeccanico(Meccanico meccanico){
        this.meccanici.remove(meccanico);
    }
    
    public void rimuoviCliente(Cliente cliente){
        this.clienti.remove(cliente);
    }
}
