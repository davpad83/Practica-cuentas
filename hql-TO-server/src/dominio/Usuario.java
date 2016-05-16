package dominio;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

import dominio.dto.UsuarioTO;

@Entity @Table(name="usuarios")
public class Usuario extends Persona {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic
	private String mail;
	 
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public UsuarioTO getDTO() {
		return new UsuarioTO(nombre, apellido, mail);
	}
	
	@Override
	public String toString() {
		return "Usuario [mail=" + mail 	+ ", nombre=" + nombre + 
				", apellido=" + apellido + ", id=" + id + "]";
	}
	


}
