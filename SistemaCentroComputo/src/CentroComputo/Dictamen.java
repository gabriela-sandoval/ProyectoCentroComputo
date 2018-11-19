package CentroComputo;

import java.sql.Date;

public class Dictamen {
	private String idDictamen;
	private Date fechaServicio;
	private String estado;
	private int numeroReporte;
	private String descripcionDictamen;
	private String observacionesEquipo;
	private Usuario tecnico;
	private Falla falla;
	
	public Dictamen(String idDictamen, Date fechaServicio, String estado, int numeroReporte, String descripcionDictamen,
			String observacionesEquipo, Usuario tecnico, Falla falla) {
		super();
		this.idDictamen = idDictamen;
		this.fechaServicio = fechaServicio;
		this.estado = estado;
		this.numeroReporte = numeroReporte;
		this.descripcionDictamen = descripcionDictamen;
		this.observacionesEquipo = observacionesEquipo;
		this.tecnico = tecnico;
		this.falla = falla;
	}
	
	public String getIdDictamen() {
		return idDictamen;
	}
	public Date getFechaServicio() {
		return fechaServicio;
	}
	public String getEstado() {
		return estado;
	}
	public int getNumeroReporte() {
		return numeroReporte;
	}
	public String getDescripcionDictamen() {
		return descripcionDictamen;
	}
	public String getObservacionesEquipo() {
		return observacionesEquipo;
	}
	public Usuario getTecnico() {
		return tecnico;
	}
	public Falla getFalla() {
		return falla;
	}
	
	
	
	

}
