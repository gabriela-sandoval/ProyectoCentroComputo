package CentroComputo;

public class Usuario {
	private String nombres;
	private String apellido;
	private String correoInstitucional;
	private String contraseña;
	private String rol;
	private String estado;
	private String numeroPersonal;
	private String telefonoConExtension;
		
	public Usuario(String nombres, String apellido, String correoInstitucional, String contraseña, String rol,
			String estado, String numeroPersonal, String telefonoConExtension) {
		super();
		this.nombres = nombres;
		this.apellido = apellido;
		this.correoInstitucional = correoInstitucional;
		this.contraseña = contraseña;
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
	public String getContraseña() {
		return contraseña;
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
