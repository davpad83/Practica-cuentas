package test;

import remoto.IGestionUsuarios;
import servicio.BS;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(IGestionUsuarios.class.toString());
		System.out.println(IGestionUsuarios.class.getProtectionDomain().getCodeSource().getLocation().toString());
		new BS().publicarServicio();
	}
}
