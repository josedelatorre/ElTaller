package models;

public abstract class Vehiculo implements Movible, Arrancable{
	//Atributos
	private String marca;
	private String matricula;
	private String color;
	private double vAct;
	private double vMax;
	private String telefonoPropietario;
	
//	public Vehiculo(String marca, String matricula, String color, double vMax, String telefonoPropietario) {
//		this.marca = marca;
//		this.matricula = matricula;
//		this.color = color;
//		this.vMax = vMax;
//		this.vAct = 0;
//		this.telefonoPropietario = telefonoPropietario;
//	}
	
	@Override
	public void arrancar(){
		System.out.println("El vehículo con matrícula " + this.matricula + 
				" ha arrancado.");
	}
	@Override
	public void detener(){
		System.out.println("El vehículo con matrícula " + this.matricula + 
				" se ha detenido.");
	}
	@Override
	public void acelerar(double velocidad){
		this.vAct += velocidad;
	}
	@Override
	public void frenar(double velocidad){
		this.vAct += velocidad;
	}
}
