package com.andreasantarsiero.mygarage.service;

import java.time.LocalDate;
import java.util.List;

import com.andreasantarsiero.mygarage.persistence.*;



public class MeccanicoService extends UtenteService{
    public static List<Appuntamento> getAppuntamenti(Meccanico meccanico){
        return meccanico.getAppuntamenti();
    }

    public static void addAppuntamento(Appuntamento appuntamento){
        appuntamento.getMeccanico().aggiungiAppuntamento(appuntamento);
    }

    
    public static boolean removeAppuntamento(Meccanico meccanico, int idAppuntamento){
        List<Appuntamento> appuntamenti = meccanico.getAppuntamenti();

        for(int i = 0; i < appuntamenti.size(); i++){
            if(appuntamenti.get(i).getId() == idAppuntamento){
                meccanico.rimuoviAppuntamento(appuntamenti.get(i));
                return true;
            }
        }
        return false;
    }


    public static boolean controllaDisponibilita(Meccanico meccanico, LocalDate data){
        for(int i = 0; i < meccanico.getAppuntamenti().size(); i++){
            if(meccanico.getAppuntamenti().get(i).getData() == data){
                return false;
            }
        }
        return true;
    }


    public static String mostraInfo(Meccanico meccanico){
        return "[nome utente: " + meccanico.getNomeUtente() + "] " + "Qualifica: " + meccanico.getQualifica() + 
                ", anni di esperienza: " + meccanico.getAnniEsperienza();
    }
}
