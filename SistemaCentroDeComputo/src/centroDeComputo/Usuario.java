package CentroComputo;

/**
 * clase del usuario del sistema
 * 
 * @author Irasema Caicero
 * @since 19/11/18
 * @version 1.0
 */
public class Usuario {
	private String nombres;
	private String apellido;
	private String correoInstitucional;
	private String contrasena;
	private String rol;
	private String estado;
	private String numeroPersonal;
	private String telefonoConExtension;
		
	public Usuario(String nombres, String apellido, String correoInstitucional, String contrasena, String rol,
			String estado, String numeroPersonal, String telefonoConExtension) {
		super();
		this.nombres = nombres;
		this.apellido = apellido;
		this.correoInstitucional = correoInstitucional;
		this.contrasena = contrasena;
		this.rol = rol;
		this.estado = estado;
		this.numeroPersonal = numeroPersonal;
		this.telefonoConExtension = telefonoConExtension;
	}
	
	public String getNombres() {
		return nombres;
	}
	public String getApellido() {
		return apellido;
	}
	public String getCorreoInstitucional() {
		return correoInstitucional;
	}
	public String getContrasena() {
		return contrasena;
	}
	public String getRol() {
		return rol;
	}
	public String getEstado() {
		return estado;
	}
	public String getNumeroPersonal() {
		return numeroPersonal;
	}
	public String getTelefonoConExtension() {
		return telefonoConExtension;
	}
	
	

}
