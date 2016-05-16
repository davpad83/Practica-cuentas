package servicio;

import hbt.HibernateDAO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;
import dominio.dto.UsuarioTO;

public class GestionUsuario extends UnicastRemoteObject implements remoto.IGestionUsuarios {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HibernateDAO hdao;

	protected GestionUsuario() throws RemoteException {
		super();
		hdao = HibernateDAO.getInstancia();
	}

	@Override
	public List<UsuarioTO> getUsuarios() throws RemoteException {
		@SuppressWarnings("unchecked")
		List<Usuario> lista = (List<Usuario>) hdao.getLista("from Usuario");
		List<UsuarioTO> dtos = new ArrayList<UsuarioTO>();
		for(Usuario usu : lista){
			dtos.add(usu.getDTO());
		}
		return dtos;
	}

	@Override
	public UsuarioTO obtenerUsuario(UsuarioTO dto) throws RemoteException {
		Usuario usu = (Usuario) hdao.propiedades("from Usuario usu where usu.apellido = :apellido", dto);
		return usu.getDTO();
	}

	@Override
	public Long cantidadUsuarios() throws RemoteException {
		return (Long) hdao.totalizador("select count(*) from Usuario");
	}

}
