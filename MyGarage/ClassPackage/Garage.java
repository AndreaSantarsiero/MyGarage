package ClassPackage;

import java.util.ArrayList;
import java.util.List;



public class Garage{
    //attributi privati
    private List<Meccanico> meccanici;
    private List<Cliente> clienti;
    private List<Macchina> macchine;


    //costruttore
    public Garage(){
        this.meccanici = new ArrayList<>();
        this.clienti = new ArrayList<>();
        this.macchine = new ArrayList<>();
    }


    //metodi per aggiungere elementi alle liste
    public void aggiungiMeccanico(Meccanico meccanico){
        meccanici.add(meccanico);
    }

    public void aggiungiCliente(Cliente cliente){
        clienti.add(cliente);
    }

    public void aggiungiMacchina(Macchina macchina){
        macchine.add(macchina);
    }


    //metodi per ottenere le liste
    public List<Meccanico> getMeccanici(){
        return meccanici;
    }

    public List<Cliente> getClienti(){
        return clienti;
    }

    public List<Macchina> getMacchine(){
        return macchine;
    }


    //contenuto del garage
    @Override
    public String toString(){
        return "Garage{" +
                "Meccanici: " + meccanici +
                ", Clienti: " + clienti +
                ", Macchine: " + macchine +
                '}';
    }
}
