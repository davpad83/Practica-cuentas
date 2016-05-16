package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import delegado.BD;
import dominio.dto.UsuarioTO;


public class Test {

	public static void main(String[] args) {
		BD bd = new BD();
		try {
			bd.LookupService(InetAddress.getLocalHost().getHostAddress());
			for(UsuarioTO usu:bd.getUsuarios()){
				System.out.println(usu);
			}
			System.out.println(bd.cantidadUsuarios());
			System.out.println(bd.getUsuario("Livorna"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
