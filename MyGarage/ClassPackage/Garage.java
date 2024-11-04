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


    //metodi per la gestione del login
    public boolean loginCliente(String username, String password){
        Cliente cliente = new Cliente();
        //cerco il cliente nella lista tramite username

        return cliente.checkPassword(password);
    }

    public boolean loginMeccanico(String username, String password){
        Meccanico meccanico = new Meccanico();
        //cerco il cliente nella lista tramite username

        return meccanico.checkPassword(password);
    }


    //metodi per cercare oggetti nel database
    public Cliente getCliente(String username, String password){  
        for (Cliente cliente : clienti) {
            if (cliente.getNomeUtente().equalsIgnoreCase(username) && cliente.checkPassword(password)){
                return cliente;     //restituisce il cliente trovato
            }
        }
        System.out.println("Cliente non trovato o password errata.");
        return null; // Return null if not found
    }

    public Meccanico getMeccanico(String username, String password){
        Meccanico meccanico = new Meccanico();
        //cerco il cliente nella lista tramite username

        return meccanico;
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
