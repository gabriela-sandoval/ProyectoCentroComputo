package CentrodeComputo;

import java.sql.Date;

/**
 * Clase del dominio de Software y sus propiedades.
 * 
 * @author Irasema Caicero
 * @version 1.0
 * @since 10/11/18
 *
 */

public class Software {

	private String idSoftware;
	private String nombre;
	private String marca;
	private String tipo;
	private int version;
	private String idioma;
	private String origen;
	private Date fechaAdquisicion;
	private String estaEnUso;
	private boolean requiereActualizacion;
	private String sistemaOperativo;
	private String observaciones;

	/**
	 * constructor del software que recibe sus propiedades
	 * 
	 * @param idSoftware            clave unica
	 * @param nombre                del software
	 * @param marca
	 * @param tipo
	 * @param version
	 * @param idioma
	 * @param origen
	 * @param fechaAdquisicion
	 * @param estaEnUso
	 * @param requiereActualizacion
	 * @param sistemaOperativo
	 * @param observaciones
	 */
	public Software(String idSoftware, String nombre, String marca, String tipo, int version, String idioma,
			String origen, Date fechaAdquisicion, String estaEnUso, boolean requiereActualizacion,
			String sistemaOperativo, String observaciones) {
		super();
		this.idSoftware = idSoftware;
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.version = version;
		this.idioma = idioma;
		this.origen = origen;
		this.fechaAdquisicion = fechaAdquisicion;
		this.estaEnUso = estaEnUso;
		this.requiereActualizacion = requiereActualizacion;
		this.sistemaOperativo = sistemaOperativo;
		this.observaciones = observaciones;
	}

	public String getIdSoftware() {
		return idSoftware;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public String getTipo() {
		return tipo;
	}

	public int getVersion() {
		return version;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getOrigen() {
		return origen;
	}

	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public String getEstaEnUso() {
		return estaEnUso;
	}

	public boolean isRequiereActualizacion() {
		return requiereActualizacion;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public String getObservaciones() {
		return observaciones;
	}

}
