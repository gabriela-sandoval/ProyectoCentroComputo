/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroDeComputo;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Dictamen {
    private String idDictamen;
	private Date fechaServicio;
	private String estado;
	private int numeroReporte;
	private String descripcionDictamen;
	private String observacionesEquipo;
	private Usuario tecnico;

	
	public Dictamen(String idDictamen, Date fechaServicio, String estado, int numeroReporte, String descripcionDictamen,
			String observacionesEquipo, Usuario tecnico) {
		super();
		this.idDictamen = idDictamen;
		this.fechaServicio = fechaServicio;
		this.estado = estado;
		this.numeroReporte = numeroReporte;
		this.descripcionDictamen = descripcionDictamen;
		this.observacionesEquipo = observacionesEquipo;
		this.tecnico = tecnico;
		
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
    
}
