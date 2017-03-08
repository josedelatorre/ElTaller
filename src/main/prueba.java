package main;

import models.*;

public class prueba {

	public static void main(String[] args) {
		
		Vehiculo v = new Motocicleta();
		Vehiculo v2 = new Motocicleta("Leo Vince");
		Vehiculo v3 = new Coche();
		
		v.arrancar();
		System.out.println();
		
	}

}
