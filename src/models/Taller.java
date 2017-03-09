package models;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

	public void insertarNuevoVehiculo() {
		int opcion = mostrarMenuInsertar();
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
		try {
			veloMax = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			// Si falla la lectura, 120km/h por defecto
			veloMax = 120;
		}

		switch (opcion) {
		case 1:// coche
			Vehiculo coche = new Coche(marca, matricula, color, veloMax, tel);
			aniadirVehiculoAveriado(coche);
			break;
		case 2:
			System.out.print("Marca del escape?: ");
			String marcaEsc = sc.nextLine();
			Vehiculo moto = new Motocicleta(marcaEsc, marca, matricula, color, veloMax, tel);
			aniadirVehiculoAveriado(moto);
			break;
		case 3:
			Vehiculo ciclo = new Ciclomotor(marca, matricula, color, veloMax, tel);
			aniadirVehiculoAveriado(ciclo);
			break;
		default:
			break;
		}
	}

	public void listarVehiculos() {
		int opcion = mostrarMenuListar();
		switch (opcion) {
		case 1:
			listarVehiculosAveriados();
			listarVehiculosReparados();
			break;
		case 2:
			listarVehiculosAveriados();
			break;
		case 3:
			listarVehiculosReparados();
			break;
		default:
			break;
		}
	}
	
	public void reparar(){
		Scanner sc = new Scanner(System.in);
		System.out.println("/** SUBMENU - REPARAR VEHICULO **/");
		System.out.print("Matricula del vehículo a reparar: ");
		String matriculaAux = sc.nextLine();
		Vehiculo vReparar = null;
		for(Vehiculo v : listaAveriados){
			if(v.getMatricula().equalsIgnoreCase(matriculaAux)){
				vReparar = v;
			}
		}
		
		//Si se encuentra, que comience la reparación.
		if(vReparar != null){
			int opcion = mostrarMenuReparar();
			repararVehiculo(vReparar, opcion);
			
		} else {
			System.out.println("[ERROR]: Vehiculo no encontrado.");
		}
	}

	private int mostrarMenuInsertar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("/** SUBMENU - CREAR VEHICULO **/");
		System.out.println("1. Coche");
		System.out.println("2. Motocicleta");
		System.out.println("3. Ciclomotor");

		System.out.println("¿Qué desea crear?: ");
		return sc.nextInt();

	}

	private int mostrarMenuListar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("/** SUBMENU - LISTAR VEHICULO **/");
		System.out.println("1. Todos");
		System.out.println("2. Averiados");
		System.out.println("3. Reparados");

		System.out.println("¿Qué desea crear?: ");
		return sc.nextInt();

	}
	
	private int mostrarMenuReparar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("/** SUBMENU - REPARAR VEHICULO **/");
		System.out.println("1. Acelerar");
		System.out.println("2. Frenar");
		System.out.println("3. Cambiar escape");
		System.out.println("4. Subir ventanillas");
		System.out.println("5. Bajar ventanillas");
		System.out.println("6. Marcar como REPARADO");
		System.out.println("7. Terminar jornada!");

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

	private void listarVehiculosAveriados() {
		System.out.println("Lista de Averiados: ");
		for (Vehiculo veh : this.getListaAveriados()) {
			if(veh instanceof Coche)
				System.out.print("[COCHE]: ");
			else if(veh instanceof Motocicleta)
				System.out.print("[MOTO]: ");
			else if(veh instanceof Ciclomotor)
				System.out.print("[CICLO]: ");
			System.out.println(veh);
		}
		if (this.getListaAveriados().isEmpty())
			System.out.println("No hay vehiculos averiados");
	}

	private void listarVehiculosReparados() {
		System.out.println("Lista de Reparados: ");
		for (Vehiculo veh : this.getListaReparados()) {
			System.out.println(veh);
		}
		if (this.getListaReparados().isEmpty())
			System.out.println("No hay vehiculos reparados");
	}
	
	private void repararVehiculo(Vehiculo v, int opcion){
		Scanner sc = new Scanner(System.in);
		int velocidad;
		String marcaEsc, confirmacion;
		switch (opcion) {
		case 1:
			System.out.println("¿Cuanto quieres acelerar?");
			velocidad = sc.nextInt();
			v.acelerar(velocidad);
			break;
		case 2:
			System.out.println("¿Cuanto quieres frenar?");
			velocidad = sc.nextInt();
			v.frenar(velocidad);
			break;
		case 3:
			if(v instanceof Motocicleta){
				System.out.println("¿Marca del escape?");
				marcaEsc = sc.nextLine();
				((Motocicleta) v).setMarcaEscape(marcaEsc);
			}
			else{
				System.out.println("[ERROR]: No podemos cambiarle el escape a un vehiculo que no es una motocicleta.");
			}
			break;
		case 4:
			if(v instanceof Coche){
				((Coche) v).subirVentanillas();
			}
			else{
				System.out.println("[ERROR]: No podemos cambiarle el escape a un vehiculo que no es un coche.");
			}
			break;
		case 5:
			if(v instanceof Coche){
				((Coche) v).bajarVentanillas();
			}
			else{
				System.out.println("[ERROR]: No podemos cambiarle el escape a un vehiculo que no es un coche.");
			}
			break;
		case 6:
			System.out.println("[CONFIRMACIÓN] ¿Quieres marcar el vehiculo "+ v.getMatricula() + " como reparado?");
			confirmacion = sc.nextLine();
			if(confirmacion.equalsIgnoreCase("SI")){
				listaAveriados.remove(v);
				listaReparados.add(v);
			}
			break;
		case 7:
			System.out.println("[SALIR] Fin de la jornada.");
			break;
		default:
			System.out.println("[ERROR] Opción no válida.");
			break;
		}
	}
	
}
