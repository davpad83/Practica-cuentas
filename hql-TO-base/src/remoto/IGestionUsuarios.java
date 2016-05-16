package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dominio.dto.UsuarioTO;


public interface IGestionUsuarios extends Remote
{
	public List<UsuarioTO> getUsuarios() throws RemoteException;
	public UsuarioTO obtenerUsuario(UsuarioTO usu) throws RemoteException;
	public Long cantidadUsuarios() throws RemoteException;
}
