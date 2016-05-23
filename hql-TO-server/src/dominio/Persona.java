package dominio;
import hbt.PersistentObject;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona extends PersistentObject{

//	@Id
//	@Column(name="ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	protected int id;

	@Column (name = "NOMBRE", nullable = false, length = 50)
	protected String nombre;
	
	@Column (name = "APELLIDO", nullable = false, length = 50)
	protected String apellido;
	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

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
