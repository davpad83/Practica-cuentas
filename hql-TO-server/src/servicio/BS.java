package servicio;

import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import remoto.IGestionUsuarios;

public class BS {
    
    public void publicarServicio() {
    	try {
    		IGestionUsuarios stub = new GestionUsuario();
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			Naming.rebind("//localhost/GestionUsuarios", stub);
//            verVinculos();
			System.out.println("servicio arriba");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void verVinculos() {
        try {
      	  String[] vinculos = Naming.list( "" );
      	  System.out.print(InetAddress.getLocalHost().getHostAddress());
      	  for ( int i = 0; i < vinculos.length; i++ ){
      		System.out.println( vinculos[i] );
      	  }
      	  System.out.print( ">>> Servicio publicado");
        }
        catch (Exception e) {
      	  e.printStackTrace();
        }
     }
    
    public void cerrar() {
		try {
			Naming.unbind("GestionUsuarios");
		} catch (Exception e) {
		} finally {
			System.exit(0);
		}
    }
}
