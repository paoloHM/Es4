package hotel;

public class Cliente {
	private String email;
	private String cognome; 
	private String nome;
	private int eta;
	
	public Cliente(String email, String cognome, String nome, int eta) {
		this.email = email;
		this.cognome = cognome;
		this.nome = nome;
		this.eta = eta;
	}
	
	public String getEmail() {
		return email;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
	
}
