package dominio;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TELEFONO")
public class Telefono {

	@EmbeddedId
	private TelefonoId IdTelefono;
	
	@Column(name="TIPO")
	private String tipo;
	
	public TelefonoId getIdTelefono() {
		return IdTelefono;
	}

	public void setIdTelefono(TelefonoId idTelefono) {
		IdTelefono = idTelefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
