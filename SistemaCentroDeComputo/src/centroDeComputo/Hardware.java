package CentroComputo;

import java.sql.Date;

/**
 * @author Irasema Caicero
 * @since 19/11/18
 * @version 1.0
 */
public class Hardware {
    
	private String noInventarioUv;
        private String marca;
        private String modelo;
	private int numeroSerie;
	private String estado;
	private String tipoDispositivo;
	private Date fechaAdquisicion;
	private String ubicacion;

    public Hardware(String noInventarioUv, String marca, String modelo, int numeroSerie, String estado, String tipoDispositivo, Date fechaAdquisicion, String ubicacion) {
        this.noInventarioUv = noInventarioUv;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.tipoDispositivo = tipoDispositivo;
        this.fechaAdquisicion = fechaAdquisicion;
        this.ubicacion = ubicacion;
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
	
}
