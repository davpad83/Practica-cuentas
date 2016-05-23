package dominio.dto;
import java.io.Serializable;


public class CuentaTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7831754573997252492L;
	private Double saldo;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
		
}
