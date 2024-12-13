package com.andreasantarsiero.mygarage.service;

import java.time.LocalDate;
import com.andreasantarsiero.mygarage.persistence.*;



public class MeccanicoService{
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
