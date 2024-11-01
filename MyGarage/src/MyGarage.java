import java.time.LocalDate;
import ClassPackage.*;



public class MyGarage{
    public static void main(String[] args) {
        //creazione del garage
        Garage garage = new Garage();



        //creazione macchine
        Macchina macchina1 = new Macchina(1, "Fiat", "Punto", 2020, 5);
        garage.aggiungiMacchina(macchina1);

        Macchina macchina2 = new Macchina(2, "Volkswagen", "Golf", 2019, 5);
        garage.aggiungiMacchina(macchina2);



        //creazione meccanici
        Meccanico meccanico1 = new Meccanico("Luca", "Verdi", LocalDate.of(1985, 7, 10), "Via Napoli 8", "NA", "80100",
                                              "luca.verdi", "luca@example.com", "password456", "Specialista", 10, "Esperto in motori diesel");
        garage.aggiungiMeccanico(meccanico1);

        Meccanico meccanico2 = new Meccanico("Sara", "Neri", LocalDate.of(1990, 4, 5), "Via Torino 12", "TO", "10100",
                                              "sara.neri", "sara@example.com", "password789", "Esperto", 5, "Specializzata in auto elettriche");
        garage.aggiungiMeccanico(meccanico2);



        //creazione clienti
        Cliente cliente1 = new Cliente("Giulia", "Bianchi", LocalDate.of(1995, 3, 20), "Via Milano 5", "MI", "20100",
                                        "giulia.bianchi", "giulia@example.com", "password123");
        garage.aggiungiCliente(cliente1);

        Cliente cliente2 = new Cliente("Marco", "Rossi", LocalDate.of(1988, 11, 15), "Via Firenze 15", "FI", "50100",
                                        "marco.rossi", "marco@example.com", "password321");
        garage.aggiungiCliente(cliente2);



        // Stampa il contenuto del garage
        System.out.println(garage);
    }
}
