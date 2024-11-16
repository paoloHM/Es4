package hotel;

public class Prenotazione {
	private String email;
	private String codiceCamera;
	private String dataInizio;
	private String dataFine;
	private int numNotti;

	public Prenotazione(String email, String codiceCamera, String dataInizio, String dataFine, int numNotti) {
		this.email = email;
		this.codiceCamera = codiceCamera;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.numNotti = numNotti;
	}

	public String getEmail() {
		return email;
	}

	public String getCodiceCamera() {
		return codiceCamera;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public int getNumNotti() {
		return numNotti;
	}

}
