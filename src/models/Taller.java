package models;

import java.util.ArrayList;

public class Taller {
	private ArrayList<Vehiculo> listaAveriados;
	private ArrayList<Vehiculo> listaReparados;
	
	public Taller(){
		this.listaAveriados = new ArrayList<Vehiculo>();
		this.listaReparados = new ArrayList<Vehiculo>();
	}
}
