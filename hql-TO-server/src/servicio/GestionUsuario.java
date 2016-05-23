package servicio;

import hbt.CuentaDAO;
import hbt.UsuarioDAO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dominio.CajaAhorro;
import dominio.Cuenta;
import dominio.Domicilio;
import dominio.Telefono;
import dominio.TelefonoId;
import dominio.Usuario;
import dominio.dto.CuentaTO;
import dominio.dto.Resultado1TO;
import dominio.dto.UsuarioTO;

public class GestionUsuario extends UnicastRemoteObject implements remoto.IGestionUsuarios {

	private UsuarioDAO usuarioDAO;
	private CuentaDAO cuentaDAO;

	protected GestionUsuario() throws RemoteException {
		super();
		usuarioDAO = UsuarioDAO.getInstancia();
		cuentaDAO = CuentaDAO.getInstancia();
	}

	
	@Override
	public List<UsuarioTO> obtenerUsuarios() throws RemoteException {
		
		List<Usuario> usuarios = usuarioDAO.getUsuarios();
		List<UsuarioTO> uTO = new ArrayList<UsuarioTO>();
		for(Usuario usu : usuarios){
			uTO.add(usu.crearUsuarioTO());
		}
		return uTO;
	}

	@Override
	public UsuarioTO obtenerUsuario(UsuarioTO dto) throws RemoteException {

		Usuario usu = usuarioDAO.obtenerUsuario(dto);
		return usu.crearUsuarioTO();
	}

	@Override
	public Long obtenerCantidadUsuarios() throws RemoteException {

		Long cantidad = usuarioDAO.obtenerCantidadUsuarios();
		return cantidad;
	}

	@Override
	public List<Resultado1TO> obtenerCantidadCuentasPorUsuario() {

		List<Resultado1TO> resultadosTO = usuarioDAO.obtenerCantidadCuentasPorUsuario();
		return resultadosTO;
	}


	@Override
	public List<Object[]> obtenerCantidadCuentasPorUsuario2() throws RemoteException {
		
		return usuarioDAO.obtenerCantidadCuentasPorUsuario2();
		
	}


	@Override
	public List<Resultado1TO> obtenerCantidadCajasAhorroPorUsuario()
			throws RemoteException {
		
		return usuarioDAO.obtenerCantidadCajasAhorroPorUsuario();
		
	}


	@Override
	public List<CuentaTO> obtenerCuentasCorrientes() throws RemoteException {
		
		return usuarioDAO.obtenerCuentasCorrientes();
	}


	@Override
	public CuentaTO obtenerCuentaConMayorSaldo() throws RemoteException {
		
		Cuenta c = cuentaDAO.obtenerCuentaConMayorSaldo();
		return c.crearCuentaTO();
	}


	@Override
	public List<UsuarioTO> obtenerPersonaDeWilde() throws RemoteException {
		
		List<Usuario> usuarios = usuarioDAO.obtenerPersonaDeWilde();
		List<UsuarioTO> uTO = new ArrayList<UsuarioTO>();
		for(Usuario usu : usuarios){
			uTO.add(usu.crearUsuarioTO());
		}
		return uTO; 
	}


	@Override
	public List<Resultado1TO> obtenerCuentaYUsuarioConSaldo2300(int saldo)
			throws RemoteException {
		
		return usuarioDAO.obtenerCuentaYUsuaroConSaldo2300(saldo);
						  
	}


	@Override
	public void insertarUsuario(UsuarioTO uTO) throws RemoteException {
		
		Usuario usuario = new Usuario();
		usuario.setApellido(uTO.getApellido());
		usuario.setMail(uTO.getMail());
		usuario.setNombre(uTO.getNombre());
		
		Telefono t = new Telefono();
		TelefonoId tid = new TelefonoId();
		tid.setArea(uTO.getTelefono().get(0).getArea());
		tid.setNumero(uTO.getTelefono().get(0).getNumero());
		t.setTipo(uTO.getTelefono().get(0).getTipo());
		t.setIdTelefono(tid);
		
		List<Telefono> telefonos = new ArrayList<Telefono>();
		telefonos.add(t);
		usuario.setTelefono(telefonos);
		Domicilio d = new Domicilio();
		d.setCodPost(uTO.getDomicilio().getCodPost());
		d.setDireccion(uTO.getDomicilio().getDireccion());
		d.setLocalidad(uTO.getDomicilio().getLocalidad());
		
		
		usuario.setDomicilio(d);
		
		CajaAhorro c = new CajaAhorro();
		c.setSaldo(uTO.getCuentas().get(0).getSaldo());
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas.add(c);
		usuario.setCuentas(cuentas);
		
		usuarioDAO.insertarUsuario(usuario);
		
	}
	
}
