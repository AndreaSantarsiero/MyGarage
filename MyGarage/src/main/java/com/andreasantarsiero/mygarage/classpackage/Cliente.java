package com.andreasantarsiero.mygarage.classpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Cliente extends Utente{
    //attributi
    private int puntiFedelta;
    private List<Macchina> macchine;


    //costruttore
    public Cliente(){
        this.macchine = new ArrayList<>();
    }

    public Cliente(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, String cap,
                   String nomeUtente, String email, String password){
        super(nome, cognome, dataDiNascita, indirizzo, provincia, cap, nomeUtente, email, password);
        this.puntiFedelta = 0;
        this.macchine = new ArrayList<>();
    }


    //metodi getter
    public int getPuntiFedelta(){
        return puntiFedelta;
    }

    public List<Macchina> getListaMacchine(){
        return macchine;
    }


    //metodi setter
    public void setPuntiFedelta(int puntiFedelta){
        this.puntiFedelta = puntiFedelta;
    }


    //metodi gestione macchine
    public void aggiungiMacchina(Macchina macchina){
        this.macchine.add(macchina);
    }

    public void rimuoviMacchina(Macchina macchina){
        this.macchine.remove(macchina);
    }


    //sottomenu cliente - macchine
    public void mostraMacchine(){
        if(macchine.isEmpty()){
            System.out.println("Non hai nessuna macchina registrata.");
        }
        else{
            System.out.println("Le tue macchine:");
            for(int i = 0; i < macchine.size(); i++){
                System.out.println((i + 1) + ") " + macchine.get(i).mostraInfoMacchina());
            }
        }
    }
    

    public void aggiungiNuovaMacchina(Scanner scanner, Id id){
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
        
        Macchina nuovaMacchina = new Macchina(id.createIdMacchina(), marca, modello, anno, numeroPorte, this);
        this.macchine.add(nuovaMacchina);
        System.out.println("Hai aggiunto una " + nuovaMacchina.mostraInfoMacchina() + " alla tua collezione!");
    }
    

    public void rimuoviMacchinaEsistente(Scanner scanner){
        if(macchine.isEmpty()){
            System.out.println("Non hai nessuna macchina registrata.");
        }
        else{
            System.out.println("Le tue macchine:");
            for(int i = 0; i < macchine.size(); i++){
                System.out.println(macchine.get(i).mostraIdEInfoMacchina());
            }

            System.out.print("Inserisci l'ID della macchina che vuoi rimuovere: ");
            int idDaRimuovere = scanner.nextInt();
            scanner.nextLine();

            boolean macchinaTrovata = false;
            for(int i = 0; i < macchine.size(); i++){
                if(macchine.get(i).getId() == idDaRimuovere){
                    this.rimuoviMacchina(macchine.get(i));
                    System.out.println("La macchina con ID " + idDaRimuovere + " è stata rimossa.");
                    macchinaTrovata = true;
                    break;
                }
            }

            if(!macchinaTrovata){
                System.out.println("Errore: l'ID inserito non corrisponde a nessuna macchina.");
            }
        }
    }



    //sottomenu cliente - appuntamenti
    public void mostraAppuntamenti(){
        if(macchine.isEmpty()){
            System.out.println("Non hai nessun appuntamento registrato.");
        }
        else{
            System.out.println("I tuoi appuntamenti:");
            for(int i = 0; i < macchine.size(); i++){
                List <Appuntamento> appuntamenti =  macchine.get(i).getListaAppuntamenti();
                for(int j = 0; j < appuntamenti.size(); j++){
                    System.out.println(appuntamenti.get(j).mostraIdEInfoAppuntamento());
                }
            }
        }   
    }


    public void prenotaNuovoAppuntamento(Scanner scanner, Id id, Garage garage){
        Macchina macchina = scegliMacchina(scanner);
        Meccanico meccanico = scegliMeccanico(scanner, garage);
        LocalDate dataAppuntamento;

        do{
            System.out.print("Data dell'appuntamento (yyyy-mm-dd): ");
            String dataInput = scanner.nextLine();
            dataAppuntamento = LocalDate.parse(dataInput);
        }while(!(meccanico.controllaDisponibilita(dataAppuntamento)));
        
        System.out.print("Motivazione dell'appuntamento: ");
        String motivazione = scanner.nextLine();
        
        Appuntamento nuovoAppuntamento = new Appuntamento(id.createIdAppuntamento(), meccanico, macchina, dataAppuntamento, motivazione);
        macchina.getListaAppuntamenti().add(nuovoAppuntamento);
        System.out.println("Hai aggiunto un nuovo appuntamento: " + nuovoAppuntamento.mostraInfoAppuntamento());
    }



    public void disdiciAppuntamentoEsistente(Scanner scanner){
        if(macchine.isEmpty()){
            System.out.println("Non hai nessun appuntamento registrato.");
        }
        else{
            System.out.println("I tuoi appuntamenti:");
            for(int i = 0; i < macchine.size(); i++){
                List <Appuntamento> appuntamenti =  macchine.get(i).getListaAppuntamenti();
                for(int j = 0; j < appuntamenti.size(); j++){
                    System.out.println(appuntamenti.get(j).mostraIdEInfoAppuntamento());
                }
            }

            System.out.print("Inserisci l'ID dell'appuntamento che vuoi rimuovere: ");
            int idDaRimuovere = scanner.nextInt();
            scanner.nextLine();

            boolean appuntamentoTrovato = false;
            for(int i = 0; i < macchine.size(); i++){
                List <Appuntamento> appuntamenti =  macchine.get(i).getListaAppuntamenti();
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

            if(!appuntamentoTrovato){
                System.out.println("Errore: l'ID inserito non corrisponde a nessun appuntamento.");
            }
        } 
    }


    private Macchina scegliMacchina(Scanner scanner){
        System.out.println("Le tue macchine:");
        for(int i = 0; i < macchine.size(); i++){
            System.out.println(macchine.get(i).mostraIdEInfoMacchina());
        }

        boolean macchinaTrovata = false;
        Macchina macchina = null;
        do{
            System.out.print("Inserisci l'ID della macchina per la quale prenotare l'appuntamento: ");
            int idMacchinaAppuntamento = scanner.nextInt();
            scanner.nextLine();

            for(int i = 0; i < macchine.size() && !macchinaTrovata; i++){
                if(macchine.get(i).getId() == idMacchinaAppuntamento){
                    macchina = macchine.get(i);
                    macchinaTrovata = true;
                }
            }

            if(!macchinaTrovata){
                System.out.println("Errore: l'ID inserito non corrisponde a nessuna macchina.");
            }
        }while(!macchinaTrovata);


        return macchina;
    }


    private Meccanico scegliMeccanico(Scanner scanner, Garage garage){
        List<Meccanico> meccanici = garage.getListaMeccanici();
        System.out.println("Meccanici disponibili:");
        for(int i = 0; i < meccanici.size(); i++){
            System.out.println(meccanici.get(i).mostraInfoMeccanico());
        }

        boolean meccanicoTrovato = false;
        Meccanico meccanico = null;
        do{
            System.out.print("Inserisci il nome utente del meccanico presso il quale prenotare l'appuntamento: ");
            String nomeUtenteMeccanicoAppuntamento = scanner.nextLine();

            for(int i = 0; i < meccanici.size() && !meccanicoTrovato; i++){
                if(meccanici.get(i).getNomeUtente().equals(nomeUtenteMeccanicoAppuntamento)){
                    meccanico = meccanici.get(i);
                    meccanicoTrovato = true;
                }
            }

            if(!meccanicoTrovato){
                System.out.println("Errore: il nome utente inserito non corrisponde a nessun meccanico.");
            }
        }while(!meccanicoTrovato);

        return meccanico;
    }



    //rappresentazione cliente come stringa
    @Override
    public String toString(){
        return "Cliente{" +
                "Punti Fedeltà: " + puntiFedelta +
                ", " + super.toString() +
                '}';
    }
}
