## MyGarage
Questo piccolo progetto consente di gestire clienti, macchine e meccanici all'interno di un garage virtuale.

## Caratteristiche
- Aggiunta e gestione di clienti
- Aggiunta e gestione di macchine
- Aggiunta e gestione di meccanici
- Visualizzazione dei dettagli del garage

## Classi Principali
- **`Persona`**: rappresenta una persona fisica
- **`Utente`**: estende `Persona`, aggiunge ad una persona fisica i dati necessari per potersi registrare sulla piattaforma
- **`Cliente`**: estende `Utente`, specializzazione dell'utente come cliente
- **`Meccanico`**: estende `Utente`, specializzazione dell'utente come meccanico
- **`Macchina`**: rappresenta una macchina fisica
- **`Garage`**: racchiude al suo interno tutti i clienti, i meccanici e le macchine registrate
- **`MyGarage`**: applicazione principale, contiene il metodo `Main`

