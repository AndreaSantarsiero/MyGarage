package ClassPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Cliente extends Utente{
    //attributi
    private int puntiFedelta;
    private List<Macchina> macchine;
    private List<Appuntamento> appuntamenti;


    //costruttore
    public Cliente(){
        this.macchine = new ArrayList<>();
        this.appuntamenti = new ArrayList<>();
    }

    public Cliente(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String provincia, String cap,
                   String nomeUtente, String email, String password){
        super(nome, cognome, dataDiNascita, indirizzo, provincia, cap, nomeUtente, email, password);
        this.puntiFedelta = 0;
        this.macchine = new ArrayList<>();
        this.appuntamenti = new ArrayList<>();
    }


    //metodi getter
    public int getPuntiFedelta(){
        return puntiFedelta;
    }

    public List<Macchina> getListaMacchine(){
        return macchine;
    }

    public List<Appuntamento> getListaAppuntamenti(){
        return appuntamenti;
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


    //metodi gestione appuntamenti
    public void aggiungiAppuntamento(Appuntamento appuntamento){
        this.appuntamenti.add(appuntamento);
    }

    public void rimuoviAppuntamento(Appuntamento appuntamento){
        this.appuntamenti.remove(appuntamento);
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
        if(appuntamenti.isEmpty()){
            System.out.println("Non hai nessun appuntamento registrato.");
        }
        else{
            System.out.println("I tuoi appuntamenti:");
            for(int i = 0; i < appuntamenti.size(); i++) {
                System.out.println((i + 1) + ") " + appuntamenti.get(i).mostraInfoAppuntamento());
            }
        }
    }


    public void prenotaNuovoAppuntamento(Scanner scanner, Id id){
        Meccanico meccanico = scegliMeccanico();    //da completare
        Macchina macchina = scegliMacchina();       //da completare
        System.out.print("Data dell'appuntamento (yyyy-mm-dd): ");
        String dataInput = scanner.nextLine();
        LocalDate dataAppuntamento = LocalDate.parse(dataInput);
        System.out.print("Motivazione dell'appuntamento: ");
        String motivazione = scanner.nextLine();
        
        Appuntamento nuovoAppuntamento = new Appuntamento(id.createIdAppuntamento(), this, meccanico, macchina, dataAppuntamento, motivazione);
        this.appuntamenti.add(nuovoAppuntamento);
        System.out.println("Hai aggiunto un nuovo appuntamento: " + nuovoAppuntamento.mostraInfoAppuntamento());
    }


    public void disdiciAppuntamentoEsistente(Scanner scanner){
        if(appuntamenti.isEmpty()){
            System.out.println("Non hai nessun appuntamento registrato.");
        }
        else{
            System.out.println("I tuoi appuntamenti:");
            for(int i = 0; i < appuntamenti.size(); i++){
                System.out.println(appuntamenti.get(i).mostraIdEInfoAppuntamento());
            }

            System.out.print("Inserisci l'ID dell'appuntamento che vuoi rimuovere: ");
            int idDaRimuovere = scanner.nextInt();
            scanner.nextLine();

            boolean appuntamentoTrovato = false;
            for(int i = 0; i < appuntamenti.size(); i++){
                if(appuntamenti.get(i).getId() == idDaRimuovere){
                    this.rimuoviAppuntamento(appuntamenti.get(i));
                    System.out.println("L'appuntamento con ID " + idDaRimuovere + " è stato rimosso.");
                    appuntamentoTrovato = true;
                    break;
                }
            }

            if(!appuntamentoTrovato){
                System.out.println("Errore: l'ID inserito non corrisponde a nessun appuntamento.");
            }
        }
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
