package com.andreasantarsiero.mygarage.userInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.andreasantarsiero.mygarage.persistence.*;
import com.andreasantarsiero.mygarage.service.*;
import com.andreasantarsiero.mygarage.utils.*;



public class ClienteUserInterface{
    public static void registraDati(Cliente cliente, Scanner scanner){
        cliente.setPuntiFedelta(0);
    }


    //sottomenu cliente - macchine
    public static void mostraMacchine(Cliente cliente){
        List<Macchina> macchine = ClienteService.getMacchine(cliente);

        if(macchine.isEmpty()){
            System.out.println("Non hai nessuna macchina registrata.");
        }
        else{
            System.out.println("Le tue macchine:");
            for(int i = 0; i < macchine.size(); i++){
                System.out.println((i + 1) + ") " + MacchinaService.mostraIdEInfo(macchine.get(i)));
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

        try{
            ClienteService.addMacchina(proprietario, nuovaMacchina);
            System.out.println("Hai aggiunto una " + MacchinaService.mostraInfo(nuovaMacchina) + " alla tua collezione!");
        } catch(IllegalArgumentException e){
            System.out.println("ERRORE: " + e.getMessage());
        }
    }
    

    public static void rimuoviMacchinaEsistente(Cliente proprietario, Scanner scanner){
        mostraMacchine(proprietario);

        System.out.print("Inserisci l'ID della macchina che vuoi rimuovere: ");
        int idDaRimuovere = scanner.nextInt();
        scanner.nextLine();

        try{
            ClienteService.removeMacchina(proprietario, idDaRimuovere);
            System.out.println("La macchina con ID " + idDaRimuovere + " è stata rimossa.");
        } catch(IllegalArgumentException e){
            System.out.println("Errore: l'ID inserito non corrisponde a nessuna macchina.");
        }
    }



    //sottomenu cliente - appuntamenti
    public static void mostraAppuntamenti(Cliente cliente){
        List<Appuntamento> appuntamenti = ClienteService.getAppuntamenti(cliente);

        if(appuntamenti.isEmpty()){
            System.out.println("Non hai nessun appuntamento registrato.");
        }
        else{
            System.out.println("I tuoi appuntamenti:");
            for(int i = 0; i < appuntamenti.size(); i++){
                System.out.println(AppuntamentoService.mostraIdEInfo(appuntamenti.get(i)));
            }
        }   
    }


    public static void prenotaNuovoAppuntamento(Cliente cliente, Scanner scanner, Id id, Garage garage){
        Macchina macchina = scegliMacchina(cliente, scanner);
        Meccanico meccanico = scegliMeccanico(garage, scanner);
        LocalDate dataAppuntamento;

        do{
            dataAppuntamento = Utils.chiediData("Data dell'appuntamento (yyyy-mm-dd): ", scanner);
        } while(MeccanicoService.controllaDisponibilita(meccanico, dataAppuntamento) == false);
        
        System.out.print("Motivazione dell'appuntamento: ");
        String motivazione = scanner.nextLine();
        
        try{
            Appuntamento nuovoAppuntamento = new Appuntamento(id.createIdAppuntamento(), meccanico, macchina, dataAppuntamento, motivazione);
            MacchinaService.addAppuntamento(nuovoAppuntamento);
            MeccanicoService.addAppuntamento(nuovoAppuntamento);
            System.out.println("Hai aggiunto un nuovo appuntamento: " + AppuntamentoService.mostraInfo(nuovoAppuntamento));
        } catch(IllegalArgumentException e){
            System.out.println("ERRORE: " + e.getMessage());
        }
    }



    public static void disdiciAppuntamentoEsistente(Cliente cliente, Scanner scanner){
        mostraAppuntamenti(cliente);
        
        System.out.print("Inserisci l'ID dell'appuntamento che vuoi rimuovere: ");
        int idDaRimuovere = scanner.nextInt();
        scanner.nextLine();

        try{
            ClienteService.removeAppuntamento(cliente, idDaRimuovere);
            System.out.println("L'appuntamento con ID " + idDaRimuovere + " è stato rimosso.");
        } catch(IllegalArgumentException e){
            System.out.println("Errore: l'ID inserito non corrisponde a nessun appuntamento.");
        }
    }


    private static Macchina scegliMacchina(Cliente proprietario, Scanner scanner){
        List<Macchina> macchine = ClienteService.getMacchine(proprietario);
        mostraMacchine(proprietario);

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


    private static Meccanico scegliMeccanico(Garage garage, Scanner scanner){
        List<Meccanico> meccanici = garage.getMeccanici();
        System.out.println("Meccanici disponibili:");
        for(int i = 0; i < meccanici.size(); i++){
            System.out.println(MeccanicoService.mostraInfo(meccanici.get(i)));
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
