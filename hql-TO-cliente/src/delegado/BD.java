package delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import remoto.IGestionUsuarios;
import dominio.dto.CuentaTO;
import dominio.dto.Resultado1TO;
import dominio.dto.UsuarioTO;

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
    	try {
    			return gestionUsu.obtenerUsuarios();
    	} catch (Exception e) {
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    	}
		return null;
    }
    
    public UsuarioTO getUsuario(String apellido) {
    	try {
    			return gestionUsu.obtenerUsuario(new UsuarioTO(null, null, apellido));
    	} catch (Exception e) {
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    			return null;
    	}
    }
    
    public Long cantidadUsuarios() {
    	try {
    			return gestionUsu.obtenerCantidadUsuarios();
    	} catch (Exception e) {
    			e.printStackTrace();
    			return null;
    	}
    }
    
    public List<Resultado1TO> obtenerCantidadCuentasPorUsuario(){
    	
    	try {
    		return gestionUsu.obtenerCantidadCuentasPorUsuario();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

	public List<Object[]> obtenerCantidadCuentasPorUsuario2() {
		
    	try {
    		return gestionUsu.obtenerCantidadCuentasPorUsuario2();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	 public List<Resultado1TO> obtenerCantidadCajasAhorroPorUsuario(){
	    	
	    	try {
	    		return gestionUsu.obtenerCantidadCajasAhorroPorUsuario();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
	
	public List<CuentaTO> obtenerCuentasCorrientes() {
		
		try {
			List<CuentaTO> ctasCorriente = gestionUsu.obtenerCuentasCorrientes(); 
			return ctasCorriente;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public CuentaTO obtenerCuentaConMayorSaldo() {
		try {
			return gestionUsu.obtenerCuentaConMayorSaldo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<UsuarioTO> obtenerPersonaDeWilde() {
		
		try {
			return gestionUsu.obtenerPersonaDeWilde();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Resultado1TO> obtenerCuentaYUsuarioConSaldo2300(int saldo) {
		try {
			return gestionUsu.obtenerCuentaYUsuarioConSaldo2300(saldo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insertarUsuario(UsuarioTO uTO) {
		try {
			gestionUsu.insertarUsuario(uTO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
