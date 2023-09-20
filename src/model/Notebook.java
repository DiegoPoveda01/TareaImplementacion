package model;

public class Notebook extends DispositivoTecnologico {
	private String resolucionDePantalla;
	private String tipoTeclado;
	private String bateria;

	public Notebook(String marca, String memoriaRam, String memoriaAlmacenamiento, String procesador, String modelo, int añoDeFabricacion, String precio, String resolucionDePantalla, String tipoTeclado, String bateria) {
		super(marca, memoriaRam, memoriaAlmacenamiento, procesador, modelo, añoDeFabricacion, precio);
		this.resolucionDePantalla = resolucionDePantalla;
		this.tipoTeclado = tipoTeclado;
		this.bateria = bateria;
	}

	public String getResolucionDePantalla() {
		return this.resolucionDePantalla;
	}

	public void setResolucionDePantalla(String resolucionDePantalla) {
		this.resolucionDePantalla = resolucionDePantalla;
	}

	public String getTipoTeclado() {
		return this.tipoTeclado;
	}

	public void setTipoTeclado(String tipoTeclado) {
		this.tipoTeclado = tipoTeclado;
	}

	public String getBateria() {
		return this.bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getTipo() {
		return "Notebook";
	}
}