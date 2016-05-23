package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dominio.dto.*;


public interface IGestionUsuarios extends Remote
{
	public List<UsuarioTO> obtenerUsuarios() throws RemoteException;
	public UsuarioTO obtenerUsuario(UsuarioTO usu) throws RemoteException;
	public Long obtenerCantidadUsuarios() throws RemoteException;
	public List<Resultado1TO> obtenerCantidadCuentasPorUsuario() throws RemoteException;
	public List<Object[]> obtenerCantidadCuentasPorUsuario2() throws RemoteException;
	public List<Resultado1TO> obtenerCantidadCajasAhorroPorUsuario() throws RemoteException;
	public List<CuentaTO> obtenerCuentasCorrientes() throws RemoteException;
	public CuentaTO obtenerCuentaConMayorSaldo() throws RemoteException;
	public List<UsuarioTO> obtenerPersonaDeWilde() throws RemoteException;
	public List<Resultado1TO> obtenerCuentaYUsuarioConSaldo2300(int saldo) throws RemoteException;
	public void insertarUsuario(UsuarioTO uTO) throws RemoteException;
}
