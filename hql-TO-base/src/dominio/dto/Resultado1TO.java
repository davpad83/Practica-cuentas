package dominio.dto;

import java.io.Serializable;


public class Resultado1TO implements Serializable{

	private String apellido;
	private int cantidadCuentas;
	
	public Resultado1TO(String apellido, int cantidadCuentas) {
		
		this.apellido = apellido;
		this.cantidadCuentas = cantidadCuentas;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCantidadCuentas() {
		return cantidadCuentas;
	}

	public void setCantidadCuentas(int cantidadCuentas) {
		this.cantidadCuentas = cantidadCuentas;
	}
	
	@Override
	public String toString() {
		return "Apellido= " + this.apellido + ", Cantidad de Cuentas= " + this.cantidadCuentas;
	}
}
