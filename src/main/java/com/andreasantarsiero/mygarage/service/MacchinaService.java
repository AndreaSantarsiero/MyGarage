package com.andreasantarsiero.mygarage.service;

import java.util.List;

import com.andreasantarsiero.mygarage.persistence.*;



public class MacchinaService{
    public static List<Appuntamento> getAppuntamenti(Macchina macchina){
        return macchina.getAppuntamenti();
    }

    public static void addAppuntamento(Appuntamento appuntamento){
        appuntamento.getMacchina().aggiungiAppuntamento(appuntamento);
    }

    
    public static boolean removeAppuntamento(Macchina macchina, int idAppuntamento){
        List<Appuntamento> appuntamenti = macchina.getAppuntamenti();

        for(int i = 0; i < appuntamenti.size(); i++){
            if(appuntamenti.get(i).getId() == idAppuntamento){
                macchina.rimuoviAppuntamento(appuntamenti.get(i));
                return true;
            }
        }
        return false;
    }


    public static String mostraInfo(Macchina macchina){
        return macchina.getMarca() + " " + macchina.getModello() + " del " + macchina.getAnno() + " "  + macchina.getNumeroPorte() + " porte";
    }

    public static String mostraIdEInfo(Macchina macchina){
        return "[ID: " + macchina.getId() + "] " + mostraInfo(macchina);
    }
}
