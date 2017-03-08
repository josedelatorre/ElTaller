package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Taller {
	private String nombre;
	private ArrayList<Vehiculo> listaAveriados;
	private ArrayList<Vehiculo> listaReparados;

	public Taller(String nombre) {
		this.nombre = nombre;
		this.listaAveriados = new ArrayList<Vehiculo>();
		this.listaReparados = new ArrayList<Vehiculo>();
	}

	public ArrayList<Vehiculo> getListaAveriados() {
		return listaAveriados;
	}

	public ArrayList<Vehiculo> getListaReparados() {
		return listaReparados;
	}

	public void listarVehiculosAveriados() {
		System.out.println("Lista de Averiados: ");
		for (Vehiculo veh : this.getListaAveriados()) {
			System.out.println(veh);
		}
		if (this.getListaAveriados().isEmpty())
			System.out.println("No hay vehiculos averiados");
	}

	public void listarVehiculosReparados() {
		System.out.println("Lista de Reparados: ");
		for (Vehiculo veh : this.getListaReparados()) {
			System.out.println(veh);
		}
		if (this.getListaReparados().isEmpty())
			System.out.println("No hay vehiculos reparados");
	}

	public void insertarNuevoVehiculo() {
		int opcion = mostrarMenu();
		String color, matricula, marca, tel;
		int veloMax = 0;
		Scanner sc = new Scanner(System.in);

		System.out.print("Color: ");
		color = sc.nextLine();
		System.out.print("Matricula: ");
		matricula = sc.nextLine();
		System.out.print("Marca: ");
		marca = sc.nextLine();
		System.out.print("Telefono del cliente: ");
		tel = sc.nextLine();
		System.out.print("Velocidad max: ");
		veloMax = sc.nextInt();
		sc.nextLine();

		switch (opcion) {
		case 1:// coche
			Vehiculo v = new Coche(marca, matricula, color, veloMax, tel);
			aniadirVehiculoAveriado(v);
			break;
		default:
			break;
		}
	}

	private static int mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("/** SUBMENU - CREAR VEHICULO **/");
		System.out.println("1. Coche");
		System.out.println("2. Motocicleta");
		System.out.println("3. Ciclomotor");

		System.out.println("¿Qué desea crear?: ");
		return sc.nextInt();

	}

	private void aniadirVehiculoAveriado(Vehiculo v) {
		if (!this.listaAveriados.contains(v)) {
			this.listaAveriados.add(v);
		} else {
			System.out.println("[ERROR] El vehiculo " + v.getMatricula() + " ya está en el taller!!!");
		}
	}
}
