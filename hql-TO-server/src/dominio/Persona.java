package dominio;
import hbt.PersistentObject;

import javax.persistence.*;

@MappedSuperclass
public class Persona extends PersistentObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String apellido;

	@Column (name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column (name = "aplellido", nullable = false, length = 8)
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
