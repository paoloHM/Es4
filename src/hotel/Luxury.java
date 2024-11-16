package hotel;

public class Luxury extends Camera{
	
	private String codiceParcheggio;
	
	public Luxury(String codicecamera, int piano, double costo, String codiceParcheggio) {
		this.codiceCamera = codicecamera;
		this.piano = piano;
		this.costo = costo;
		this.codiceParcheggio = codiceParcheggio;
	}

	public String getCodiceParcheggio() {
		return codiceParcheggio;
	}
	
	@Override
	public String toString() {
		return codiceCamera.replace("_", " ")+" "+codiceParcheggio;
	}

}

