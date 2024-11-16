package hotel;

public class Camera{
	
	protected int piano;
	protected String codiceCamera;
	protected double costo;
	
	public String getCodiceCamera() {
		return codiceCamera;
	}

	public int getPiano() {
		return piano;
	}

	public double getCosto() {
		return costo;
	}
	
	@Override
	public String toString() {
		return codiceCamera.replace("_", " ");
	}

}
