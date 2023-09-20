package model;

public class ComputadorDeEscritorio extends DispositivoTecnologico {
	private String tarjetaDeVideo;
	private String fuenteDePoder;
	private String chasis;
	private Pantalla pantalla;

	public ComputadorDeEscritorio(String marca, String memoriaRam, String memoriaAlmacenamiento, String procesador, String modelo, int añoDeFabricacion, String precio, String tarjetaDeVideo, String fuenteDePoder, String chasis, Pantalla pantalla) {
		super(marca, memoriaRam, memoriaAlmacenamiento, procesador, modelo, añoDeFabricacion, precio);
		this.tarjetaDeVideo = tarjetaDeVideo;
		this.fuenteDePoder = fuenteDePoder;
		this.chasis = chasis;
		this.pantalla = pantalla;
	}

	public String getTarjetaDeVideo() {
		return this.tarjetaDeVideo;
	}

	public void setTarjetaDeVideo(String tarjetaDeVideo) {
		this.tarjetaDeVideo = tarjetaDeVideo;
	}

	public String getFuenteDePoder() {
		return this.fuenteDePoder;
	}

	public void setFuenteDePoder(String fuenteDePoder) {
		this.fuenteDePoder = fuenteDePoder;
	}

	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getTipo() {
		return "Computador de Escritorio";
	}
}