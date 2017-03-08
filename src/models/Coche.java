package models;

public class Coche extends Vehiculo {
	private String ventanillas;

	public Coche(String marca, String matricula, String color, 
			double vMax, String telefonoPropietario) {
		
		super(marca,matricula,color,vMax,telefonoPropietario);
		subirVentanillas();
	}

	public String getVentanillas() {
		return ventanillas;
	}

	public void subirVentanillas() {
		this.ventanillas = "Subidas";
	}

	public void bajarVentanillas() {
		this.ventanillas = "Bajadas";
	}

}
