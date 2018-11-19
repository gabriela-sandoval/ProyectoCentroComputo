package CentroComputo;

import java.sql.Date;

public class Hardware {
	
	private String noInventarioUv;
	private int numeroSerie;
	private String modelo;
	private String marca;
	private String tipoDispositivo;
	private String estado;
	private String ubicacion;
	private Date fechaAdquisicion;
	private Licencia garantia;
	
	public Hardware(String noInventarioUv, int numeroSerie, String modelo, String marca, String tipoDispositivo,
			String estado, String ubicacion, Date fechaAdquisicion, Licencia garantia) {
		super();
		this.noInventarioUv = noInventarioUv;
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
		this.marca = marca;
		this.tipoDispositivo = tipoDispositivo;
		this.estado = estado;
		this.ubicacion = ubicacion;
		this.fechaAdquisicion = fechaAdquisicion;
		this.garantia = garantia;
	}
	
	public String getNoInventarioUv() {
		return noInventarioUv;
	}
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public String getModelo() {
		return modelo;
	}
	public String getMarca() {
		return marca;
	}
	public String getTipoDispositivo() {
		return tipoDispositivo;
	}
	public String getEstado() {
		return estado;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public Licencia getGarantia() {
		return garantia;
	}
	

}
