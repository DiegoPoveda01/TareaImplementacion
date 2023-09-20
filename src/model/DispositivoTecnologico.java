package model;

public abstract class DispositivoTecnologico {
	protected String marca;
	protected String memoriaRam;
	protected String memoriaAlmacenamiento;
	protected String procesador;
	protected String modelo;
	protected int añoDeFabricacion;
	protected String precio;
	protected int stock;
   public DispositivoTecnologico(String marca, String memoriaRam, String memoriaAlmacenamiento, String procesador, String modelo, int añoDeFabricacion, String precio){
	   this.marca= marca;
	   this.memoriaRam = memoriaRam;
	   this.memoriaAlmacenamiento = memoriaAlmacenamiento;
	   this.procesador = procesador;
	   this.modelo = modelo;
	   this.añoDeFabricacion = añoDeFabricacion;
	   this.precio = precio;
   }
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMemoriaRam() {
		return this.memoriaRam;
	}

	public void setMemoriaRam(String memoriaRam) {
		this.memoriaRam = memoriaRam;
	}

	public String getMemoriaAlmacenamiento() {
		return this.memoriaAlmacenamiento;
	}

	public void setMemoriaAlmacenamiento(String memoriaAlmacenamiento) {
		this.memoriaAlmacenamiento = memoriaAlmacenamiento;
	}

	public String getProcesador() {
		return this.procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAñoDeFabricacion() {
		return this.añoDeFabricacion;
	}

	public void setAñoDeFabricacion(int añoDeFabricacion) {
		this.añoDeFabricacion = añoDeFabricacion;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public abstract String getTipo();
}