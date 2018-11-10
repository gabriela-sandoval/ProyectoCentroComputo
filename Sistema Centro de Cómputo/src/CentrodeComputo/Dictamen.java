package CentrodeComputo;

import java.sql.Date;

/**
 * clase de dominio del Dictamen con sus propiedades
 * 
 * @author Irasema Caicero
 * @version 1.0
 * @since 10/11/18
 *
 */
public class Dictamen {
	
	private String idDictamen;
	private int numeroReporte;
	private Date fechaServicio;
	private String tipoDictamen;
	private String descripcionDetalladaDictamen;
	private String descripcionProblema;
	private String observacionesEquipo;
	private String partesDispositivo;
	private String tipoMantenimiento;
	
	/**
	 * constructor del Dictamen que recibe sus propiedades
	 * @param idDictamen
	 * @param numeroReporte
	 * @param fechaServicio
	 * @param tipoDictamen
	 * @param descripcionDetalladaDictamen
	 * @param descripcionProblema
	 * @param observacionesEquipo
	 * @param partesDispositivo
	 * @param tipoMantenimiento
	 */
	public Dictamen(String idDictamen, int numeroReporte, Date fechaServicio, String tipoDictamen,
			String descripcionDetalladaDictamen, String descripcionProblema, String observacionesEquipo,
			String partesDispositivo, String tipoMantenimiento) {
		super();
		this.idDictamen = idDictamen;
		this.numeroReporte = numeroReporte;
		this.fechaServicio = fechaServicio;
		this.tipoDictamen = tipoDictamen;
		this.descripcionDetalladaDictamen = descripcionDetalladaDictamen;
		this.descripcionProblema = descripcionProblema;
		this.observacionesEquipo = observacionesEquipo;
		this.partesDispositivo = partesDispositivo;
		this.tipoMantenimiento = tipoMantenimiento;
	}

	public String getIdDictamen() {
		return idDictamen;
	}

	public int getNumeroReporte() {
		return numeroReporte;
	}

	public Date getFechaServicio() {
		return fechaServicio;
	}

	public String getTipoDictamen() {
		return tipoDictamen;
	}

	public String getDescripcionDetalladaDictamen() {
		return descripcionDetalladaDictamen;
	}

	public String getDescripcionProblema() {
		return descripcionProblema;
	}

	public String getObservacionesEquipo() {
		return observacionesEquipo;
	}

	public String getPartesDispositivo() {
		return partesDispositivo;
	}

	public String getTipoMantenimiento() {
		return tipoMantenimiento;
	}

}
