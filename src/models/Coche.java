package models;

public class Coche extends Vehiculo{
	private String ventanillas;
	
	public Coche(){
		subirVentanillas();
	}
	
	public void subirVentanillas(){
		this.ventanillas = "Subidas";
	}
	
	public void bajarVentanillas(){
		this.ventanillas = "Bajadas";
	}

}
