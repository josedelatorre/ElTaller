package main;

import java.util.Scanner;

import models.*;

public class prueba {

	private static Taller t;

	public static void main(String[] args) {

		t = new Taller("Midas");
		int opcion;
		do {
			opcion = mostrarMenu();
			realizarOpcion(opcion);
		} while (opcion != 5);
	}

	public static int mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("/** MENU **/");
		System.out.println("1. A�adir vehiculo");
		System.out.println("2. Reparar vehiculo");
		System.out.println("3. Listar vehiculos");
		System.out.println("4. Entregar vehiculo");
		System.out.println("5. Capturar a Ratata");

		System.out.println("�Qu� desea hacer?: ");
		sc.close();
		return sc.nextInt();

	}

	public static void realizarOpcion(int option) {
		int opcion = 0;
		System.out.println("Vamos alla!");
		switch (opcion) {
		case 1:
			t.insertarVehiculoNuevo();
			break;
		case 2:
			t.reparar();
			break;
		case 3:
			t.listarVehiculos();
			break;
		case 4:
			
			break;
		case 5:
			System.out.println("Capturando a Ratata!!! Buenas tardes.");
			break;
		default:
			System.out.println("[ERROR] Opci�n no v�lida.");
			break;
		}

	}

}
