package ClassPackage;

import java.util.ArrayList;
import java.util.List;



public class Garage{
    //attributi privati
    private List<Meccanico> meccanici;
    private List<Cliente> clienti;


    //costruttore
    public Garage(){
        this.meccanici = new ArrayList<>();
        this.clienti = new ArrayList<>();
    }


    //metodi per aggiungere elementi alle liste
    public void aggiungiMeccanico(Meccanico meccanico){
        meccanici.add(meccanico);
    }

    public void aggiungiCliente(Cliente cliente){
        clienti.add(cliente);
    }


    //metodi per ottenere le liste
    public List<Meccanico> getListaMeccanici(){
        return meccanici;
    }

    public List<Cliente> getListaClienti(){
        return clienti;
    }


    //metodi per la gestione del login
    public boolean loginCliente(String username, String password){
        for(Cliente cliente : clienti){
            if(cliente.getNomeUtente().equals(username)){
                return cliente.checkPassword(password);
            }
        }

        return false;
    }
    

    public boolean loginMeccanico(String username, String password){
    for(Meccanico meccanico : meccanici){
        if(meccanico.getNomeUtente().equals(username)){
            return meccanico.checkPassword(password);
        }
    }

    return false;
}



    //metodi per cercare oggetti nel database
    public Cliente getCliente(String username, String password){  
        for(Cliente cliente : clienti){
            if(cliente.getNomeUtente().equals(username)){
                return cliente;
            }
        }

        System.out.println("Username non trovato.");
        return null;
    }

    public Meccanico getMeccanico(String username, String password){
        for(Meccanico meccanico : meccanici){
            if(meccanico.getNomeUtente().equals(username)){
                return meccanico;
            }
        }

        System.out.println("Username non trovato.");
        return null;
    }


    //contenuto del garage
    @Override
    public String toString(){
        return "Garage{" +
                "Meccanici: " + meccanici +
                ", Clienti: " + clienti +
                '}';
    }
}
