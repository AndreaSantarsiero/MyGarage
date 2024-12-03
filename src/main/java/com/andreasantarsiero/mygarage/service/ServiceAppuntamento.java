package com.andreasantarsiero.mygarage.service;

import com.andreasantarsiero.mygarage.persistence.*;



public class ServiceAppuntamento{
    //metodi
     public static String mostraInfo(Appuntamento appuntamento){
        return "Meccanico: " + appuntamento.getMeccanico().getNomeUtente() + ", Macchina: " +
               appuntamento.getMacchina().getMarca() + " " + appuntamento.getMacchina().getModello() + ", Data: " + 
               appuntamento.getData() + ", Motivazione: " + appuntamento.getMotivazione();
    }

    public static String mostraIdEInfo(Appuntamento appuntamento){
        return "[ID: " + appuntamento.getId() + "] " + mostraInfo(appuntamento);
    }
}
