package hotel;

public class Hotel {
	
	private Cliente[] clienti = new Cliente[100];
	private int idexClienti=0;
	private int LuxuryCount = 1;
	private int StandardCount = 1;
	private Camera[] camere = new Camera[100];
	private int count = 0;
	public Hotel(){
		
	}
	
	public Cliente registraCliente(String email, String cognome, String nome, int eta) {
		if (eta>=18) {
			if (cercaCliente(email)==null) {
				Cliente clienteTemp = new Cliente(email,cognome,nome,eta);
				clienti[idexClienti++] = clienteTemp;
			} else {
				cercaCliente(email).setCognome(cognome);
				cercaCliente(email).setNome(nome);
				cercaCliente(email).setEta(eta);
			}
			return cercaCliente(email);
		}
		return null;
	}
	
	public Cliente cercaCliente(String email) {
		for(int i=0;i<idexClienti;i++) {
			if(clienti[i].getEmail().equals(email)) {return clienti[i];}
		}
		return null;
	}
	
	public Cliente[] clienti() {
		Cliente clientiTemp[] = new Cliente[idexClienti];
		for(int i=0;i<idexClienti;i++) {clientiTemp[i]=clienti[i];}
		return clientiTemp;
	}
	
	public Camera aggiungiCamera(char tipologia, int piano, double costo) {
		if(piano<=10) {
			String codiceTemp = ""+tipologia+"_"+piano+"_";
			if (tipologia == 'S') {
				codiceTemp += ""+StandardCount;
				Standard cameraTemp = new Standard(codiceTemp,piano,costo);
				camere[count++] = cameraTemp;
				StandardCount++;
				return cameraTemp;
			}
			if (tipologia == 'L') {
				codiceTemp += ""+LuxuryCount;
				Luxury cameraTemp = new Luxury(codiceTemp,piano,costo,"P"+LuxuryCount);
				camere[count++] = cameraTemp;
				LuxuryCount++;
				return cameraTemp;
			}
		}
		return null;
	}
	
	public Camera cercaCamera(String codiceCamera) {
		for(int i=0; i<count;i++) {
			if (camere[i].getCodiceCamera().equals(codiceCamera)) {
				return camere[i];
			}
		}
		return null;
	}
	
	public Camera[] camere() {
		Camera camereTemp[] = new Camera[count];
		for(int i=0;i<count;i++) {camereTemp[i]=camere[i];}
		return camereTemp;
	}
	
	public String elencoCamere() {
		String result = "";
		for(Camera camera:camere()) {
			result += camera.toString()+"\n";
		}
		return result;
	}
	
	public Camera[] cercaCamereDisponibili(char tipologia, String dataInizio, String dataFine) {
		
		return null;
	}
	
	public Camera nuovaPrenotazione(String email, String codiceCamera, String dataInizio, String dataFine, int numNotti) {
		return null;
	}
	
	public double calcolaCostoPrenotazioniCliente(String email) {
		return -1;
	}
	
	
	public double calcolaCostoPrenotazioni() {
		return -1;
	}

	
	public String elencoPrenotazioniCliente(String email) {
		return null;
	}
	
	
	public String elencoPrenotazioniCameraOrdinatePerDataDiInizio(String codiceCamera) {
		return null;
	}
	
	
}


