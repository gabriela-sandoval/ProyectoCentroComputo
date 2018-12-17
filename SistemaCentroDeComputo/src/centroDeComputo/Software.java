package CentroComputo;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * clase de software a administrar 
 * 
 * @author Irasema Caicero
 * @since 19/11/18
 * @version 1.0
 */
public class Software {
	private String idSoftware;
        private String nombre; 
	private String origen;
	private String observaciones;
        private Date fechaAdquisicion;
        private String tipoSoftware;
        private String marca;
        private boolean requiereActualizacion;
	private double version;
	private boolean disponible;
	private String sistemaOperativo;
	private String idioma;
	
        /**
         * constructor por default
        **/
	public Software() {
		
	}

    public Software(String idSoftware, String nombre, String origen, String observaciones, 
            Date fechaAdquisicion, String tipoSoftware, String marca, boolean requiereActualizacion, 
            double version, boolean disponible, String sistemaOperativo, String idioma) {
        this.idSoftware = idSoftware;
        this.nombre = nombre;
        this.origen = origen;
        this.observaciones = observaciones;
        this.fechaAdquisicion = fechaAdquisicion;
        this.tipoSoftware = tipoSoftware;
        this.marca = marca;
        this.requiereActualizacion = requiereActualizacion;
        this.version = version;
        this.disponible = disponible;
        this.sistemaOperativo = sistemaOperativo;
        this.idioma = idioma;
    }

    public String getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(String idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getTipoSoftware() {
        return tipoSoftware;
    }

    public void setTipoSoftware(String tipoSoftware) {
        this.tipoSoftware = tipoSoftware;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isRequiereActualizacion() {
        return requiereActualizacion;
    }

    public void setRequiereActualizacion(boolean requiereActualizacion) {
        this.requiereActualizacion = requiereActualizacion;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    } 

}
