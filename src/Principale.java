import hotel.*;

public class Principale {

    public static void main(String[] args) {

        Hotel h = new Hotel();

        // R1. Clienti

        System.out.println("Aggiunto cliente");

        Cliente cl1 = h.registraCliente("mario.rossi@gmail.com", "Rossi", "Mario", 25);

        System.out.println("\nInformazioni cliente aggiunto");

        System.out.println("Email: " + cl1.getEmail());
        System.out.println("Cognome: " + cl1.getCognome());
        System.out.println("Nome: " + cl1.getNome());
        System.out.println("Eta': " + cl1.getEta());

        System.out.println("\nAggiunto altro cliente");

        Cliente cl2 = h.registraCliente("andrea.bianchi@gmail.com", "Bianchi", "Andrea", 31);

        System.out.println("\nInformazioni cliente aggiunto");

        System.out.println("Email: " + cl2.getEmail());
        System.out.println("Cognome: " + cl2.getCognome());
        System.out.println("Nome: " + cl2.getNome());
        System.out.println("Eta': " + cl2.getEta());

        System.out.println("\nRicerca cliente: mario.rossi@gmail.com");

        Cliente clTrovato = h.cercaCliente("mario.rossi@gmail.com");

        System.out.println("\nInformazioni cliente trovato");

        System.out.println("Email: " + clTrovato.getEmail());
        System.out.println("Cognome: " + clTrovato.getCognome());
        System.out.println("Nome: " + clTrovato.getNome());
        System.out.println("Eta': " + clTrovato.getEta());

        System.out.println("\nElenco clienti");
        Cliente[] clientiRegistrati = h.clienti();

        if (clientiRegistrati != null) {
            for (Cliente ci : clientiRegistrati) {
                System.out.println(ci.getEmail());
            }
        } else {
            System.out.println("Nessun cliente registrato");
        }

        // R2. Camere

        System.out.println("\nCreazione camera di tipo Standard");

        System.out.println("\nAggiunta camera");

        Camera c1 = h.aggiungiCamera('S', 3, 80);

        if (c1 instanceof Standard)
            System.out.println("Tipologia: Standard");
        else if (c1 instanceof Luxury)
            System.out.println("Tipologia: Luxury");
        else
            System.out.println("Tipologia: N/D");

        System.out.println("\nInformazioni camera aggiunta");

        System.out.println("Codice camera: " + c1.getCodiceCamera());
        System.out.println("Piano: " + c1.getPiano());
        System.out.println("Costo per notte: " + c1.getCosto());

        System.out.println("\nCreazione camera di tipo Luxury");

        Camera c2 = h.aggiungiCamera('L', 1, 120);

        System.out.println("\nInformazioni camera aggiunta");

        if (c2 instanceof Standard)
            System.out.println("Tipologia: Standard");
        else if (c2 instanceof Luxury)
            System.out.println("Tipologia: Luxury");
        else
            System.out.println("Tipologia: N/D");

        System.out.println("Codice camera: " + c2.getCodiceCamera());
        System.out.println("Piano: " + c2.getPiano());
        System.out.println("Costo per notte: " + c2.getCosto());

        System.out.println("\nRicerca camera: L_1_1");

        Camera cTrovata = h.cercaCamera("L_1_1");

        System.out.println("\nInformazioni camera trovata");

        System.out.println("Codice camera: " + cTrovata.getCodiceCamera());
        System.out.println("Piano: " + cTrovata.getPiano());
        System.out.println("Costo per notte (con il costo per il posto auto aggiunto): " + cTrovata.getCosto());

        System.out.println("\nElenco camere");
        String elencoCamere = h.elencoCamere();
        System.out.println(elencoCamere);

        // R3. Prenotazioni e costi

        System.out.println("Ricerca di camere disponibili di tipo Luxury dal 20231124 al 20231126");
        Camera[] camereDisponibili = h.cercaCamereDisponibili('L', "20231124", "20231126");

        if (camereDisponibili == null) {
            System.out.println("\nCamere di tipologia Luxury non disponibili per i parametri usati");
        } else {
            System.out.println("\nCodici camere disponibili di tipologia Luxury");
            for (Camera ci : camereDisponibili) {
                System.out.println(ci.getCodiceCamera());
            }
        }

        System.out.println("\nPrenotazione camera L_1_1 da parte di mario.rossi@gmail.com");
        Camera cameraPrenotata = h.nuovaPrenotazione("mario.rossi@gmail.com", "L_1_1", "20231124", "20231126", 2);

        System.out.println("\nCodice camera prenotata");

        System.out.println("Codice camera: " + cameraPrenotata.getCodiceCamera());
        System.out.println("Piano: " + cameraPrenotata.getPiano());
        System.out.println("Costo per notte (con il costo per il posto auto aggiunto): " + cameraPrenotata.getCosto());

        System.out.println("\nAltra prenotazione di una camera S_3_1 da parte di mario.rossi@gmail.com");
        h.nuovaPrenotazione("mario.rossi@gmail.com", "S_3_1", "20231125", "20231126", 1);

        System.out.println("\nAltra prenotazione di una camera L_1_1 da parte di andrea.bianchi@gmail.com (per stanza già prenotata)");
        h.nuovaPrenotazione("andrea.bianchi@gmail.com", "L_1_1", "20231124", "20231125", 1);
        
        System.out.println("\nAltra prenotazione di una camera S_3_1 da parte di andrea.bianchi@gmail.com");
        h.nuovaPrenotazione("andrea.bianchi@gmail.com", "S_3_1", "20231123", "20231124", 1);

        System.out.println("\nCalcolo della somma dei costi delle prenotazioni dell'utente mario.rossi@gmail.com");
        double costoTotaleCliente = h.calcolaCostoPrenotazioniCliente("mario.rossi@gmail.com");
        System.out.println(costoTotaleCliente + " euro");

        System.out.println("\nCalcolo della somma dei costi delle prenotazioni effettuate");
        double costoTotalePrenotazioni = h.calcolaCostoPrenotazioni();
        System.out.println(costoTotalePrenotazioni + " euro");

        // R4. Elenchi

        System.out.println("\nElenco prenotazioni dell'utente mario.rossi@gmail.com");
        String prenotazioniCliente = h.elencoPrenotazioniCliente("mario.rossi@gmail.com");
        System.out.println(prenotazioniCliente);

        System.out.println("Elenco prenotazioni per la camera L_1_1 in ordine di data");
        String prenotazioniCamera = h.elencoPrenotazioniCameraOrdinatePerDataDiInizio("L_1_1");
        System.out.println(prenotazioniCamera);

    }
}