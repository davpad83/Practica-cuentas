package delegado;

import java.rmi.*;
import java.util.List;

import dominio.dto.UsuarioTO;
import remoto.IGestionUsuarios;

public class BD {
    
	IGestionUsuarios gestionUsu;
	
    public void LookupService(String uri) {
    	try {
    		String vinculo = "//".concat(uri.trim().concat("/GestionUsuarios"));
			gestionUsu = (IGestionUsuarios)Naming.lookup (vinculo);
			System.out.println(vinculo);
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
		} 
    }
    
    public List<UsuarioTO> getUsuarios() {
    	List<UsuarioTO> lista = null;
    	try {
    			lista = gestionUsu.getUsuarios();
    	} catch (Exception e) {
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    	}
		return lista;
    }
    
    public UsuarioTO getUsuario(String apellido) {
    	try {
    			return  gestionUsu.obtenerUsuario(new UsuarioTO(null, apellido, null));
    	} catch (Exception e) {
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    			return null;
    	}
    }
    
    public Long cantidadUsuarios() {
    	try {
    			return  gestionUsu.cantidadUsuarios();
    	} catch (Exception e) {
    			e.printStackTrace();
    			return null;
    	}
    }
}
