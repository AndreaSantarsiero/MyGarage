package com.andreasantarsiero.mygarage.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.andreasantarsiero.mygarage.persistence.*;



public class ServiceCliente{
    //sottomenu cliente - macchine
    public static void mostraMacchine(Cliente cliente){
        if(cliente.getMacchine().isEmpty()){
            System.out.println("Non hai nessuna macchina registrata.");
        }
        else{
            System.out.println("Le tue macchine:");
            for(int i = 0; i < cliente.getMacchine().size(); i++){
                System.out.println((i + 1) + ") " + ServiceMacchina.mostraInfo(cliente.getMacchine().get(i)));
            }
        }
    }
    

    public static void aggiungiNuovaMacchina(Cliente proprietario, Scanner scanner, Id id){
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modello: ");
        String modello = scanner.nextLine();
        System.out.print("Anno: ");
        int anno = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Numero di porte: ");
        int numeroPorte = scanner.nextInt();
        scanner.nextLine();
        
        Macchina nuovaMacchina = new Macchina(id.createIdMacchina(), marca, modello, anno, numeroPorte, proprietario);
        proprietario.getMacchine().add(nuovaMacchina);
        System.out.println("Hai aggiunto una " + ServiceMacchina.mostraInfo(nuovaMacchina) + " alla tua collezione!");
    }
    

    public static void rimuoviMacchinaEsistente(Cliente proprietario, Scanner scanner){
        if(proprietario.getMacchine().isEmpty()){
            System.out.println("Non hai nessuna macchina registrata.");
        }
        else{
            System.out.println("Le tue macchine:");
            for(int i = 0; i < proprietario.getMacchine().size(); i++){
                System.out.println(ServiceMacchina.mostraIdEInfo(proprietario.getMacchine().get(i)));
            }

            System.out.print("Inserisci l'ID della macchina che vuoi rimuovere: ");
            int idDaRimuovere = scanner.nextInt();
            scanner.nextLine();

            boolean macchinaTrovata = false;
            for(int i = 0; i < proprietario.getMacchine().size(); i++){
                if(proprietario.getMacchine().get(i).getId() == idDaRimuovere){
                    proprietario.rimuoviMacchina(proprietario.getMacchine().get(i));
                    System.out.println("La macchina con ID " + idDaRimuovere + " è stata rimossa.");
                    macchinaTrovata = true;
                    break;
                }
            }

            if(macchinaTrovata == false){
                System.out.println("Errore: l'ID inserito non corrisponde a nessuna macchina.");
            }
        }
    }



    //sottomenu cliente - appuntamenti
    public static void mostraAppuntamenti(Cliente cliente){
        if(cliente.getMacchine().isEmpty()){
            System.out.println("Non hai nessun appuntamento registrato.");
        }
        else{
            System.out.println("I tuoi appuntamenti:");
            for(int i = 0; i < cliente.getMacchine().size(); i++){
                List <Appuntamento> appuntamenti =  cliente.getMacchine().get(i).getAppuntamenti();
                for(int j = 0; j < appuntamenti.size(); j++){
                    System.out.println(ServiceAppuntamento.mostraIdEInfo(appuntamenti.get(j)));
                }
            }
        }   
    }


    public static void prenotaNuovoAppuntamento(Cliente cliente, Scanner scanner, Id id, Garage garage){
        Macchina macchina = scegliMacchina(cliente.getMacchine(), scanner);
        Meccanico meccanico = scegliMeccanico(scanner, garage);
        LocalDate dataAppuntamento;

        do{
            System.out.print("Data dell'appuntamento (yyyy-mm-dd): ");
            String dataInput = scanner.nextLine();
            dataAppuntamento = LocalDate.parse(dataInput);
        } while(ServiceMeccanico.controllaDisponibilita(meccanico, dataAppuntamento) == false);
        
        System.out.print("Motivazione dell'appuntamento: ");
        String motivazione = scanner.nextLine();
        
        Appuntamento nuovoAppuntamento = new Appuntamento(id.createIdAppuntamento(), meccanico, macchina, dataAppuntamento, motivazione);
        macchina.getListaAppuntamenti().add(nuovoAppuntamento);
        System.out.println("Hai aggiunto un nuovo appuntamento: " + ServiceAppuntamento.mostraInfo(nuovoAppuntamento));
    }



    public static void disdiciAppuntamentoEsistente(Cliente cliente, Scanner scanner){
        List<Macchina> macchine = cliente.getMacchine();
        if(macchine.isEmpty()){
            System.out.println("Non hai nessun appuntamento registrato.");
        }
        else{
            System.out.println("I tuoi appuntamenti:");
            for(int i = 0; i < macchine.size(); i++){
                List <Appuntamento> appuntamenti =  macchine.get(i).getAppuntamenti();
                for(int j = 0; j < appuntamenti.size(); j++){
                    System.out.println(ServiceAppuntamento.mostraIdEInfo(appuntamenti.get(j)));
                }
            }

            System.out.print("Inserisci l'ID dell'appuntamento che vuoi rimuovere: ");
            int idDaRimuovere = scanner.nextInt();
            scanner.nextLine();

            boolean appuntamentoTrovato = false;
            for(int i = 0; i < macchine.size(); i++){
                List <Appuntamento> appuntamenti =  macchine.get(i).getAppuntamenti();
                for(int j = 0; j < appuntamenti.size(); j++){
                    if(appuntamenti.get(j).getId() == idDaRimuovere){
                        appuntamenti.get(j).getMeccanico().rimuoviAppuntamento(appuntamenti.get(j));
                        macchine.get(i).rimuoviAppuntamento(appuntamenti.get(j));
                        System.out.println("L'appuntamento con ID " + idDaRimuovere + " è stato rimosso.");
                        appuntamentoTrovato = true;
                        break;
                    }
                }
            }

            if(appuntamentoTrovato == false){
                System.out.println("Errore: l'ID inserito non corrisponde a nessun appuntamento.");
            }
        } 
    }


    private static Macchina scegliMacchina(List<Macchina> macchine, Scanner scanner){
        System.out.println("Le tue macchine:");
        for(int i = 0; i < macchine.size(); i++){
            System.out.println(ServiceMacchina.mostraIdEInfo(macchine.get(i)));
        }

        boolean macchinaTrovata = false;
        Macchina macchina = null;
        do{
            System.out.print("Inserisci l'ID della macchina per la quale prenotare l'appuntamento: ");
            int idMacchinaAppuntamento = scanner.nextInt();
            scanner.nextLine();

            for(int i = 0; i < macchine.size() && macchinaTrovata == false; i++){
                if(macchine.get(i).getId() == idMacchinaAppuntamento){
                    macchina = macchine.get(i);
                    macchinaTrovata = true;
                }
            }

            if(macchinaTrovata == false){
                System.out.println("Errore: l'ID inserito non corrisponde a nessuna macchina.");
            }
        }while(macchinaTrovata == false);


        return macchina;
    }


    private static Meccanico scegliMeccanico(Scanner scanner, Garage garage){
        List<Meccanico> meccanici = garage.getMeccanici();
        System.out.println("Meccanici disponibili:");
        for(int i = 0; i < meccanici.size(); i++){
            System.out.println(ServiceMeccanico.mostraInfo(meccanici.get(i)));
        }

        boolean meccanicoTrovato = false;
        Meccanico meccanico = null;
        do{
            System.out.print("Inserisci il nome utente del meccanico presso il quale prenotare l'appuntamento: ");
            String nomeUtenteMeccanicoAppuntamento = scanner.nextLine();

            for(int i = 0; i < meccanici.size() && meccanicoTrovato == false; i++){
                if(meccanici.get(i).getNomeUtente().equals(nomeUtenteMeccanicoAppuntamento)){
                    meccanico = meccanici.get(i);
                    meccanicoTrovato = true;
                }
            }

            if(meccanicoTrovato == false){
                System.out.println("Errore: il nome utente inserito non corrisponde a nessun meccanico.");
            }
        }while(meccanicoTrovato == false);

        return meccanico;
    }
}
