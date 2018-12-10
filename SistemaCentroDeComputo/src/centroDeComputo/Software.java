package CentroComputo;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author Irasema Caicero
 * @since 19/11/18
 * @version 1.0
 */
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
	private boolean requiereActualizacion;
	private String observaciones;
        private boolean disponible;
	
	
        /**
         * constructor por default
        **/
	public Software() {
		
	}
        
	
	public Software(String nombre, String idSoftware, String marca, double version, String origen, String tipoSoftware,
			Date fechaAdquisicion, String idioma, String sistemaOperativo, boolean requiereActualizacion,
			String observaciones, boolean disponible) {
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
                this.disponible=disponible;
		
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
	public boolean getRequiereActualizacion() {
		return requiereActualizacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
        public boolean getDisponible(){
            return disponible;
        }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdSoftware(String idSoftware) {
        this.idSoftware = idSoftware;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setTipoSoftware(String tipoSoftware) {
        this.tipoSoftware = tipoSoftware;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;     
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public void setRequiereActualizacion(boolean requiereActualizacion) {
        this.requiereActualizacion = requiereActualizacion;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public void setDisponible(boolean disponible){
        this.disponible=disponible;
    }
    
    private SimpleDateFormat darFormatoAFecha(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        formatoFecha.format(fecha);      
            return null;
    }

   
        
	
	

}
