package ClassPackage;

import java.time.LocalDate;



public class Appuntamento{
    //attributi
    private int id;
    private Cliente cliente;
    private Meccanico meccanico;
    private Macchina macchina;
    private LocalDate data;
    private String motivazione;


    //costruttore
    public Appuntamento(){}

    public Appuntamento(int id, Cliente cliente, Meccanico meccanico, Macchina macchina, LocalDate data, String motivazione){
        this.id = id;
        this.cliente = cliente;
        this.meccanico = meccanico;
        this.macchina = macchina;
        this.data = data;
        this.motivazione = motivazione;
    }

    //metodi getter
    public int getId(){
        return id;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Meccanico getMeccanico(){
        return meccanico;
    }

    public Macchina getMacchina(){
        return macchina;
    }

    public LocalDate getData(){
        return data;
    }

    public String getMotivazione(){
        return motivazione;
    }


    //metodi setter
    public void setId(int id){
        this.id = id;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public void setMeccanico(Meccanico meccanico){
        this.meccanico = meccanico;
    }

    public void setMacchina(Macchina macchina){
        this.macchina = macchina;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }


    //rappresentazione appuntamento come stringa
    @Override
    public String toString() {
        return "Appuntamento [ID: " + id + ", Cliente: " + cliente.getNomeUtente() + ", Meccanico: " + meccanico.getNomeUtente() + ", Macchina: " +
               macchina.getMarca() + " " + macchina.getModello() + ", Data: " + data + ", Motivazione: " + motivazione + "]";
    }

    public String mostraInfoAppuntamento(){
        return "Meccanico: " + meccanico.getNomeUtente() + ", Macchina: " +
               macchina.getMarca() + " " + macchina.getModello() + ", Data: " + data + ", Motivazione: " + motivazione + "]";
    }

    public String mostraIdEInfoAppuntamento(){
        return "[ID: " + id + "] Meccanico: " + meccanico.getNomeUtente() + ", Macchina: " +
               macchina.getMarca() + " " + macchina.getModello() + ", Data: " + data + ", Motivazione: " + motivazione + "]";
    }
}
