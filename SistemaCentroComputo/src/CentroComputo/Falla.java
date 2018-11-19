package CentroComputo;

public class Falla {
	private Responsable solicitante;
	private Hardware equipo;
	private String tipoFalla;
	private String descripcionProblema;
	private String partesEquipo;
	
	public Falla(Responsable solicitante, Hardware equipo, String tipoFalla, String descripcionProblema,
			String partesEquipo) {
		super();
		this.solicitante = solicitante;
		this.equipo = equipo;
		this.tipoFalla = tipoFalla;
		this.descripcionProblema = descripcionProblema;
		this.partesEquipo = partesEquipo;
	}
	
	public Responsable getSolicitante() {
		return solicitante;
	}
	public Hardware getEquipo() {
		return equipo;
	}
	public String getTipoFalla() {
		return tipoFalla;
	}
	public String getDescripcionProblema() {
		return descripcionProblema;
	}
	public String getPartesEquipo() {
		return partesEquipo;
	}
	



}
