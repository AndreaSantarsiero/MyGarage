package ClassPackage;



public class Macchina{
    //attributi
    private int id;
    private String marca;
    private String modello;
    private int anno;
    private int numeroPorte;


    //costruttore
    public Macchina(){}
    
    public Macchina(int id, String marca, String modello, int anno, int numeroPorte){
        this.id = id;
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.numeroPorte = numeroPorte;
    }


    //metodi getter
    public int getId(){
        return id;
    }

    public String getMarca(){
        return marca;
    }

    public String getModello(){
        return modello;
    }

    public int getAnno(){
        return anno;
    }

    public int getNumeroPorte(){
        return numeroPorte;
    }


    //metodi setter
    public void setId(int id){
        this.id = id;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModello(String modello){
        this.modello = modello;
    }

    public void setAnno(int anno){
        this.anno = anno;
    }

    public void setNumeroPorte(int numeroPorte){
        this.numeroPorte = numeroPorte;
    }


    //rappresentazione macchina come stringa
    @Override
    public String toString(){
        return "Macchina{" +
                "ID: " + id +
                ", Marca: '" + marca + '\'' +
                ", Modello: '" + modello + '\'' +
                ", Anno: " + anno +
                ", Numero Porte: " + numeroPorte +
                '}';
    }
}
