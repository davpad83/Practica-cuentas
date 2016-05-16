package dominio.dto;

public class UsuarioTO extends PersonaTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mail;
	 
	public UsuarioTO(String nombre, String apellido, String mail) {
		super(nombre, apellido);
		this.mail = mail;
	}
	
	public String getMail() {
		return mail;
	}

	@Override
	public String toString() {
		return "UsuarioTO [mail=" + mail + ", nombre=" + nombre + ", apellido="
				+ apellido + "]";
	}
}
