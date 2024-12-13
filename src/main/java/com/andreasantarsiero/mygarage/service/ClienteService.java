package com.andreasantarsiero.mygarage.service;

import java.util.List;
import java.util.ArrayList;
import com.andreasantarsiero.mygarage.persistence.*;



public class ClienteService{
    public static List<Macchina> getMacchine(Cliente cliente){
        return cliente.getMacchine();
    }

    public static void addMacchina(Cliente proprietario, Macchina macchina){
        proprietario.aggiungiMacchina(macchina);
    }


    public static boolean removeMacchina(Cliente proprietario, int idMacchina){
        List<Macchina> macchine = ClienteService.getMacchine(proprietario);

        for(int i = 0; i < macchine.size(); i++){
            if(macchine.get(i).getId() == idMacchina){
                proprietario.rimuoviMacchina(macchine.get(i));
                return true;
            }
        }
        return false;
    }


    public static List<Appuntamento> getAppuntamenti(Cliente cliente){
        List<Macchina> macchine = cliente.getMacchine();
        List<Appuntamento> appuntamentiCliente = new ArrayList<>();

        for(int i = 0; i < macchine.size(); i++){
            List <Appuntamento> appuntamenti =  MacchinaService.getAppuntamenti(macchine.get(i));
            for(int j = 0; j < appuntamenti.size(); j++){
                appuntamentiCliente.add(appuntamenti.get(i));
            }
        }
        return appuntamentiCliente;
    }


    public static boolean removeAppuntamento(Cliente cliente, int idAppuntamento){
        List<Macchina> macchine = cliente.getMacchine();

        for(int i = 0; i < macchine.size(); i++){
            List<Appuntamento> appuntamenti = macchine.get(i).getAppuntamenti();

            for(int j = 0; j < appuntamenti.size(); j++){
                if(appuntamenti.get(j).getId() == idAppuntamento){
                    macchine.get(i).rimuoviAppuntamento(appuntamenti.get(j));
                    return true;
                }
            }
        }
        return false;
    }
}
