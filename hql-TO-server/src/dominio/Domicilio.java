package dominio;

import hbt.PersistentObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Domicilio extends PersistentObject{

	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="CODIGO_POSTAL")
	private String codPost;

	@Column(name="LOCALIDAD")
	private String localidad;
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodPost() {
		return codPost;
	}

	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	
}
