package controller;

import data.Data;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Tienda {
	private String direccion;
	private ArrayList<DispositivoTecnologico> catalogo;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<DispositivoTecnologico> dispositivos = new ArrayList<DispositivoTecnologico>();

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<DispositivoTecnologico> getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(ArrayList<DispositivoTecnologico> catalogo) {
		this.catalogo = catalogo;
	}

	public Cliente buscarCliente(String email) {
		for (Cliente cliente : clientes) {
			if (cliente.getEmail().equals(email)) {
				return cliente;
			}
		}
		return null;
	}

	public void agregarCliente(Cliente cliente) {
		String email = cliente.getEmail();
		Cliente clienteExistente = buscarCliente(email);
		if (clienteExistente == null) {
			clientes.add(cliente);
			System.out.println("Cliente agregado.");
		} else {
			System.out.println("El cliente no puede ser agregado nuevamente.");
		}
	}

	public void agregarDispositivo(DispositivoTecnologico dispositivo, int cantidad) {
		catalogo.add(dispositivo);
		if (catalogo.contains(dispositivo)) {
			dispositivo.setStock(dispositivo.getStock() + cantidad);
			System.out.println("Stock del dispositivo '" + dispositivo.getModelo() + "' incrementado en " + cantidad + " unidades.");
		} else {
			System.out.println("El dispositivo no se encuentra en el catálogo.");
		}
	}


	public void realizarVenta(Cliente cliente, DispositivoTecnologico dispositivo) {
		if (catalogo.contains(dispositivo)) {
			if (dispositivo.getStock() > 0) {
				cliente.getDispositivos().add(dispositivo);
				dispositivo.setStock(dispositivo.getStock() - 1);
				System.out.println("Venta realizada con éxito.");
			} else {
				System.out.println("El dispositivo no está disponible en stock.");
			}
		} else {
			System.out.println("El dispositivo no se encuentra en el catálogo.");
		}
	}

	public DispositivoTecnologico buscarDispositivo(String modelo) {
		String modeloLowerCase = modelo.toLowerCase();
		for (DispositivoTecnologico dispositivo : catalogo) {
			if (dispositivo.getModelo().toLowerCase().equals(modeloLowerCase)) {
				return dispositivo;
			}
		}
		return null;
	}


	public String obtenerInformacionCatalogo() {
		StringBuilder catalogoInfo = new StringBuilder();

		catalogoInfo.append("Información del Catálogo de Dispositivos Tecnológicos:\n");
		catalogoInfo.append("----------------------------------------------\n");

		for (DispositivoTecnologico dispositivo : catalogo) {
			catalogoInfo.append("Tipo de Dispositivo: ").append(dispositivo.getTipo()).append("\n");
			catalogoInfo.append("Modelo: ").append(dispositivo.getModelo()).append("\n");
			catalogoInfo.append("Marca: ").append(dispositivo.getMarca()).append("\n");
			catalogoInfo.append("Procesador: ").append(dispositivo.getProcesador()).append("\n");
			catalogoInfo.append("RAM: ").append(dispositivo.getMemoriaRam()).append("\n");
			catalogoInfo.append("Almacenamiento: ").append(dispositivo.getMemoriaAlmacenamiento()).append("\n");
			catalogoInfo.append("Precio: ").append(dispositivo.getPrecio()).append("\n");
			catalogoInfo.append("Año de Fabricación: ").append(dispositivo.getAñoDeFabricacion()).append("\n");
			catalogoInfo.append("Stock: ").append(dispositivo.getStock()).append("\n");
			catalogoInfo.append("----------------------------------------------\n");
		}

		return catalogoInfo.toString();
	}

	public static void inicializarTienda() {
		Tienda tienda = new Tienda();
		tienda.setDireccion("Calle 123 # 45 - 67");
		Pantalla pantalla = new Pantalla();
		tienda.setCatalogo(new ArrayList<>(new Data().leerCSV()));
		tienda.setCatalogo(new ArrayList<DispositivoTecnologico>());
		Tablet tablet1 = new Tablet("Samsung", "4 GB", "64 GB", "Exynos 9611", "Galaxy Tab S6 Lite", 2020, "$1.499.900", "2000 x 1200", new ArrayList<>(Arrays.asList("S Pen")));
		tienda.agregarDispositivo(tablet1, 10);

		Tablet tablet2 = new Tablet("Apple", "4 GB", "32 GB", "Apple A10 Fusion", "iPad 7", 2019, "$1.299.900", "2160 x 1620", new ArrayList<>(Arrays.asList("Apple Pencil")));
		tienda.agregarDispositivo(tablet2, 10);

		Notebook notebook1 = new Notebook("Lenovo", "8 GB", "1 TB", "Intel Core i5", "IdeaPad 3", 2020, "$2.499.900", "1366x768", "60%", "46Wh");
		tienda.agregarDispositivo(notebook1, 10);
		ComputadorDeEscritorio computadorDeEscritorio = new ComputadorDeEscritorio("HP", "8 GB", "1 TB", "Intel Core i5", "Pavilion 590", 2018, "$2.999.900", "NVIDIA GeForce GTX 1050", "310W", "Torre", pantalla);
		//No se agregó el computador a la tienda para probar el caso en el que no se encuentra en el catálogo
		Cliente cliente1 = new Cliente("Juan", "Perez", "juan.perez01@gmail.com", "9998383", "Soltero", "Bogotá", tienda);
		Cliente cliente2 = new Cliente("Maria", "Gonzalez", "maria.gonzales02@gmail.com", "91238129", "Casada", "Medellín", tienda);
		tienda.agregarCliente(cliente1);
		tienda.agregarCliente(cliente2);
		tienda.realizarVenta(cliente1, tablet1);
		tienda.realizarVenta(cliente1, tablet2);
		tienda.realizarVenta(cliente2, notebook1);
		tienda.realizarVenta(cliente2, computadorDeEscritorio);
		tienda.buscarDispositivo("Galaxy Tab S6 Lite");
		tienda.buscarDispositivo("IdeaPad 3");
		tienda.buscarDispositivo("MacBook Air");
		cliente1.buscarDispositivos("Tablet");
		cliente1.buscarDispositivos("Notebook");
		cliente2.buscarDispositivos("Tablet");
		cliente2.buscarDispositivos("Computador de Escritorio");
		System.out.println(tienda.obtenerInformacionCatalogo());
		new Data().escribirCSV(tienda.getCatalogo());
	}
}

