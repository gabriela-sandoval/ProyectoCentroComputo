package CentroComputo;

public class Responsable extends Usuario {
	private String nombres;
	private String apellido;
	private String correoInstitucional;
	private String numeroPersonal;
	private String telefonoConExtension;
	
	
	public Responsable(String nombres, String apellido, String correoInstitucional, String contraseña, String rol,
			String estado, String numeroPersonal, String telefonoConExtension, String nombres2, String apellido2,
			String correoInstitucional2, String numeroPersonal2, String telefonoConExtension2) {
		super(nombres, apellido, correoInstitucional, contraseña, rol, estado, numeroPersonal, telefonoConExtension);
		nombres = nombres2;
		apellido = apellido2;
		correoInstitucional = correoInstitucional2;
		numeroPersonal = numeroPersonal2;
		telefonoConExtension = telefonoConExtension2;
	}

	
	

}
