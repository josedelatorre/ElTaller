package models;

public class Motocicleta extends Vehiculo {
	private String marcaEscape;

	public Motocicleta(String marca, String matricula, String color, 
			double vMax, String telefonoPropietario) {
		super(marca,matricula,color,vMax,telefonoPropietario);
	}

	public Motocicleta(String marcaEscape, String marca, String matricula, String color, 
			double vMax, String telefonoPropietario) {
		super(marca,matricula,color,vMax,telefonoPropietario);
		this.marcaEscape = marcaEscape;
	}

	public String getMarcaEscape() {
		return marcaEscape;
	}
	
	public void setMarcaEscape(String marcaEscape){
		this.marcaEscape = marcaEscape;
	}

}
