package com.andreasantarsiero.mygarage.service;

import com.andreasantarsiero.mygarage.persistence.*;



public class MacchinaService{
    public static String mostraInfo(Macchina macchina){
        return macchina.getMarca() + " " + macchina.getModello() + " del " + macchina.getAnno() + " "  + macchina.getNumeroPorte() + " porte";
    }

    public static String mostraIdEInfo(Macchina macchina){
        return "[ID: " + macchina.getId() + "] " + mostraInfo(macchina);
    }
}
