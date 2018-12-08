package CentroComputo;

import java.sql.Date;

public class Software {
	private String nombre; 
	private String idSoftware;
	private String marca;
	private double version;
	private String origen;
	private String tipoSoftware;
	private Date fechaAdquisicion;
	private String idioma;
	private String sistemaOperativo;
	private String requiereActualizacion;
	private String observaciones;
	private Licencia licencia;
	
	public Software(String nombre, String idSoftware, String marca, double version, String origen, String tipoSoftware,
			Date fechaAdquisicion, String idioma, String sistemaOperativo, String requiereActualizacion,
			String observaciones) {
		super();
		this.nombre = nombre;
		this.idSoftware = idSoftware;
		this.marca = marca;
		this.version = version;
		this.origen = origen;
		this.tipoSoftware = tipoSoftware;
		this.fechaAdquisicion = fechaAdquisicion;
		this.idioma = idioma;
		this.sistemaOperativo = sistemaOperativo;
		this.requiereActualizacion = requiereActualizacion;
		this.observaciones = observaciones;
	}
	
	public Software(String nombre, String idSoftware, String marca, double version, String origen, String tipoSoftware,
			Date fechaAdquisicion, String idioma, String sistemaOperativo, String requiereActualizacion,
			String observaciones, Licencia licencia) {
		super();
		this.nombre = nombre;
		this.idSoftware = idSoftware;
		this.marca = marca;
		this.version = version;
		this.origen = origen;
		this.tipoSoftware = tipoSoftware;
		this.fechaAdquisicion = fechaAdquisicion;
		this.idioma = idioma;
		this.sistemaOperativo = sistemaOperativo;
		this.requiereActualizacion = requiereActualizacion;
		this.observaciones = observaciones;
		this.licencia = licencia;
	}
	public String getNombre() {
		return nombre;
	}
	public String getIdSoftware() {
		return idSoftware;
	}
	public String getMarca() {
		return marca;
	}
	public double getVersion() {
		return version;
	}
	public String getOrigen() {
		return origen;
	}
	public String getTipoSoftware() {
		return tipoSoftware;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public String getIdioma() {
		return idioma;
	}
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public String getRequiereActualizacion() {
		return requiereActualizacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public Licencia getLicencia() {
		return licencia;
	}
	
	
	

}
