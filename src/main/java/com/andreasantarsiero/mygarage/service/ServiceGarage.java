package com.andreasantarsiero.mygarage.service;

import java.util.ArrayList;
import java.util.List;
import com.andreasantarsiero.mygarage.persistence.*;



public class ServiceGarage{
     //metodi per la gestione del login
    public boolean loginCliente(String username, String password){
        for(Cliente cliente : clienti){
            if(cliente.getNomeUtente().equals(username)){
                return cliente.checkPassword(password);
            }
        }

        return false;
    }
    

    public boolean loginMeccanico(String username, String password){
    for(Meccanico meccanico : meccanici){
        if(meccanico.getNomeUtente().equals(username)){
            return meccanico.checkPassword(password);
        }
    }

    return false;
}



    //metodi per cercare oggetti nel database
    public Cliente getCliente(String username, String password){  
        for(Cliente cliente : clienti){
            if(cliente.getNomeUtente().equals(username)){
                return cliente;
            }
        }

        System.out.println("Username non trovato.");
        return null;
    }

    public Meccanico getMeccanico(String username, String password){
        for(Meccanico meccanico : meccanici){
            if(meccanico.getNomeUtente().equals(username)){
                return meccanico;
            }
        }

        System.out.println("Username non trovato.");
        return null;
    }
}
