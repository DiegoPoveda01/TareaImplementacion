package model;

import java.util.ArrayList;

import controller.Tienda;

public class Cliente {
	private String nombre;
	private String apellido;
	private String email;
	private String numeroContacto;
	private String estadoCivil;
	private String ciudad;
	private ArrayList<DispositivoTecnologico> dispositivos = new ArrayList<DispositivoTecnologico>();
	private Tienda tienda;

	public Cliente(String nombre, String apellido, String email, String numeroContacto, String estadoCivil, String ciudad, Tienda tienda){
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.numeroContacto = numeroContacto;
		this.estadoCivil = estadoCivil;
		this.ciudad = ciudad;
		this.dispositivos = dispositivos;
		this.tienda = tienda;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroContacto() {
		return this.numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Tienda getTienda(){return this.tienda;}
	public void setTienda(Tienda tienda){this.tienda = tienda;}
	public ArrayList<DispositivoTecnologico> getDispositivos(){return this.dispositivos;}
	public void setDispositivos(ArrayList<DispositivoTecnologico> dispositivos){this.dispositivos = dispositivos;}

	public ArrayList<DispositivoTecnologico> buscarDispositivos(String tipo) {
		ArrayList<DispositivoTecnologico> dispositivosEncontrados = new ArrayList<>();
		for (DispositivoTecnologico dispositivo : tienda.getCatalogo()) {
			if (dispositivo.getTipo().equalsIgnoreCase(tipo)) {
				dispositivosEncontrados.add(dispositivo);
			}
		}
		return dispositivosEncontrados;
	}
}