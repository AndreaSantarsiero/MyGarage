package ClassPackage;



public class Id{
    //attributi
    private int numeroMacchine;


    //costruttore
    public Id(){
        this.numeroMacchine = 0;
    }


    //metodi createId (per inizializzare oggetti)
    public int createIdMacchina(){
        numeroMacchine++;
        return numeroMacchine;
    }
}

