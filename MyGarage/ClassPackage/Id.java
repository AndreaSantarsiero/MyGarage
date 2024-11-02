package ClassPackage;



public class Id{
    //attributi
    private int numeroClienti;
    private int numeroMeccanici;
    private int numeroMacchine;


    //costruttore
    public Id(){
        this.numeroClienti = 0;
        this.numeroMeccanici = 0;
        this.numeroMacchine = 0;
    }


    //metodi createId (per inizializzare oggetti)
    public int createIdCliente(){
        numeroClienti++;
        return numeroClienti;
    }

    public int createIdMeccanico(){
        numeroMeccanici++;
        return numeroMeccanici;
    }
    
    public int createIdMacchina(){
        numeroMacchine++;
        return numeroMacchine;
    }
}

