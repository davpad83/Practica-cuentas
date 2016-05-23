package dominio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UsuarioTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mail;
	private String nombre;
	private String apellido;
	private List<CuentaTO> cuentas = new ArrayList<CuentaTO>();
	private DomicilioTO domicilio;
	private List<TelefonoTO> telefono;
	

	public UsuarioTO(String mail, String nombre, String apellido) {

//		super(nombre, apellido);
		this.mail = mail;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	
	
	public List<CuentaTO> getCuentas() {
		return cuentas;
	}



	public void setCuentas(List<CuentaTO> cuentas) {
		this.cuentas = cuentas;
	}



	public DomicilioTO getDomicilio() {
		return domicilio;
	}



	public void setDomicilio(DomicilioTO domicilio) {
		this.domicilio = domicilio;
	}



	public List<TelefonoTO> getTelefono() {
		return telefono;
	}



	public void setTelefono(List<TelefonoTO> telefono) {
		this.telefono = telefono;
	}



	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
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
