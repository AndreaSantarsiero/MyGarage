package com.andreasantarsiero.mygarage.service;

import com.andreasantarsiero.mygarage.persistence.*;



public class ServiceGarage{
    //metodi gestione login
    public static boolean loginCliente(Garage garage, String username, String password){
        for(Cliente cliente : garage.getClienti()){
            if(cliente.getNomeUtente().equals(username)){
                return cliente.checkPassword(password);
            }
        }

        return false;
    }
    
    
    public static boolean loginMeccanico(Garage garage, String username, String password){
        for(Meccanico meccanico : garage.getMeccanici()){
            if(meccanico.getNomeUtente().equals(username)){
                return meccanico.checkPassword(password);
            }
        }

        return false;
    }



    //metodi ricerca istanze nel database
    public static Cliente getCliente(Garage garage, String username, String password){  
        for(Cliente cliente : garage.getClienti()){
            if(cliente.getNomeUtente().equals(username)){
                return cliente;
            }
        }

        System.out.println("Username non trovato.");
        return null;
    }


    public static Meccanico getMeccanico(Garage garage, String username, String password){
        for(Meccanico meccanico : garage.getMeccanici()){
            if(meccanico.getNomeUtente().equals(username)){
                return meccanico;
            }
        }

        System.out.println("Username non trovato.");
        return null;
    }
}
