package dominio;

import hbt.PersistentObject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import dominio.dto.CuentaTO;

@Entity
@Table(name="CUENTA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="TIPO", discriminatorType=DiscriminatorType.STRING)
public abstract class Cuenta extends PersistentObject{

//	@Id
//	@Column(name="ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	protected int id;
	
	@Column(name="SALDO")
	private Double saldo;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public abstract Date getFechaCreacion();
		
	public CuentaTO crearCuentaTO(){
		CuentaTO cTO = new CuentaTO();
		cTO.setSaldo(this.saldo);
		return cTO;
	}
}
