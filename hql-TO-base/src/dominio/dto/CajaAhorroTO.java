package dominio.dto;

import java.io.Serializable;
import java.util.Date;

public class CajaAhorroTO extends CuentaTO implements Serializable{

	private Date fechaCreacion;
	
	public CajaAhorroTO(Double saldo) {
		super();
		this.setSaldo(saldo);
		this.fechaCreacion = new Date();
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
}
