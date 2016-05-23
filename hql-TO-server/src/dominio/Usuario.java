package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dominio.dto.UsuarioTO;

@Entity 
@Table(name="USUARIO")
public class Usuario extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="MAIL")
	private String mail;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USUARIO_CUENTA", joinColumns=@JoinColumn(name="ID_USUARIO"), inverseJoinColumns=@JoinColumn(name="ID_CUENTA"))
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	@Embedded
	private Domicilio domicilio;
	 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_USUARIO")	
	private List<Telefono> telefono;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
		
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public List<Telefono> getTelefono() {
		return telefono;
	}
	public void setTelefono(List<Telefono> telefono) {
		this.telefono = telefono;
	}
	public UsuarioTO crearUsuarioTO() {
		return new UsuarioTO(this.mail, this.nombre, this.apellido);
	}
	
	@Override
	public String toString() {
		return "Usuario [mail=" + mail 	+ ", nombre=" + nombre + 
				", apellido=" + apellido + ", id=" + id + "]";
	}
	


}
