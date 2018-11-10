package CentrodeComputo;

import java.sql.Date;

/**
 * Clase del dominio de Hardware y sus propiedades
 * 
 * @author Irasema Caicero
 * @version 1.0
 * @since 10/11/18
 *
 */

public class Hardware {
	
	private int numeroInventario;
	private int numeroSerie;
	private String tipoDispositivo;
	private String marca;
	private String modelo;
	private Date fechaAdquisicion;
	private String ubicacion;
	private String estadoDispositivo;
	
	/**
	 * constructor de Hardware  que recibe sus propiedades. 
	 * @param numeroInventario
	 * @param numeroSerie
	 * @param tipoDispositivo
	 * @param marca
	 * @param modelo
	 * @param fechaAdquisicion
	 * @param ubicacion
	 * @param estadoDispositivo
	 */
	public Hardware(int numeroInventario, int numeroSerie, String tipoDispositivo, String marca, String modelo,
			Date fechaAdquisicion, String ubicacion, String estadoDispositivo) {
		this.numeroInventario = numeroInventario;
		this.numeroSerie = numeroSerie;
		this.tipoDispositivo = tipoDispositivo;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaAdquisicion = fechaAdquisicion;
		this.ubicacion = ubicacion;
		this.estadoDispositivo = estadoDispositivo;
	}
	
	public int getNumeroInventario() {
		return numeroInventario;
	}
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public String getTipoDispositivo() {
		return tipoDispositivo;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public String getEstadoDispositivo() {
		return estadoDispositivo;
	}

}
