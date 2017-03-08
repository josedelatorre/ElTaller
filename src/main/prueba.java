package main;

import models.*;

public class prueba {

	public static void main(String[] args) {
		
		Vehiculo v = new Motocicleta("Honda", "2343VCC", "Amarillo", 200, "698553324");
		Vehiculo v2 = new Motocicleta("Leo Vince","Honda", "2343VCC", "Amarillo", 200, "698553324");

		
		v.arrancar();
		v.acelerar(20);
		System.out.println(v.getvAct() + "km/h");
		System.out.println(v.getColor());
		((Motocicleta) v).getMarcaEscape();
		
	}

}
