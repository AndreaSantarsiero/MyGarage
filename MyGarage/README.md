## MyGarage
Questo piccolo progetto consente di gestire clienti, macchine e meccanici all'interno di un garage virtuale.

## Caratteristiche
clienti: 
- gestione delle proprie macchine 
- gestione degli appuntamenti presso meccanici
meccanici:
- gestione degli appuntamenti che i clienti hanno prenotato
garage:
- Visualizzazione dei dettagli del garage

## Classi Principali
- **`Persona`**: rappresenta una persona fisica
- **`Utente`**: estende `Persona`, aggiunge ad una persona fisica i dati necessari per potersi registrare sulla piattaforma
- **`Cliente`**: estende `Utente`, specializzazione dell'utente come cliente
- **`Meccanico`**: estende `Utente`, specializzazione dell'utente come meccanico
- **`Macchina`**: rappresenta una macchina fisica
- **`Appuntamento`**: permette ai clienti di prenotare appuntamenti per le loro macchine presso meccanici, se sono disponibili
- **`Garage`**: racchiude al suo interno tutti i clienti, i meccanici e le macchine registrate
- **`MyGarage`**: applicazione principale, contiene il metodo `Main`

