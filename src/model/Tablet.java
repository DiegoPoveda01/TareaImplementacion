package model;

import java.util.ArrayList;

public class Tablet extends DispositivoTecnologico {
	private String resolucionDePantalla;
	private ArrayList<String> accesoriosIncorporados;

	public Tablet(String marca, String memoriaRam, String memoriaAlmacenamiento, String procesador, String modelo, int añoDeFabricacion, String precio, String resolucionDePantalla, ArrayList<String> accesoriosIncorporados) {
		super(marca, memoriaRam, memoriaAlmacenamiento, procesador, modelo, añoDeFabricacion, precio);
		this.resolucionDePantalla = resolucionDePantalla;
		this.accesoriosIncorporados = accesoriosIncorporados;
	}

	public String getResolucionDePantalla() {
		return this.resolucionDePantalla;
	}

	public void setResolucionDePantalla(String resolucionDePantalla) {
		this.resolucionDePantalla = resolucionDePantalla;
	}

	public ArrayList<String> getAccesoriosIncorporados() {
		throw new UnsupportedOperationException();
	}

	public void setAccesoriosIncorporados(ArrayList<String> accesoriosIncorporados) {
		this.accesoriosIncorporados = accesoriosIncorporados;
	}

	public String getTipo() {
		return "Tablet";
	}
}