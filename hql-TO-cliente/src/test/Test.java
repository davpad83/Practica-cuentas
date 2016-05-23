package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import delegado.BD;
import dominio.dto.CajaAhorroTO;
import dominio.dto.CuentaTO;
import dominio.dto.DomicilioTO;
import dominio.dto.Resultado1TO;
import dominio.dto.TelefonoTO;
import dominio.dto.UsuarioTO;


public class Test {

	public static void main(String[] args) {
		BD bd = new BD();
		try {
			bd.LookupService(InetAddress.getLocalHost().getHostAddress());
			
			System.out.println("\n-->>>LISTA DE TODOS LOS USUARIOS:");
			for(UsuarioTO usu:bd.getUsuarios()){
				System.out.println("\t"+usu);
			}
			System.out.println("\n-->>CANTIDAD DE USUARIOS:");
			System.out.println("\t"+bd.cantidadUsuarios());
			
			System.out.println("\n-->>USUARIO APELLIDO PADUA:");
			System.out.println("\t"+bd.getUsuario("Padua"));
			
			System.out.println("\n-->>CANTIDAD DE CUENTAS POR USUARIO:");
			List<Resultado1TO> resultados = bd.obtenerCantidadCuentasPorUsuario();
			for (int i = 0; i < resultados.size(); i++) {
				System.out.println("\t" + resultados.get(i));
			}
			
//			System.out.println("\n-->>CANTIDAD DE CUENTAS POR USUARIO SEGUNDA FORMA:");
//			List<Object[]> resultados2 = bd.obtenerCantidadCuentasPorUsuario2();
//			for (Object[] tupla : resultados2) {
//				System.out.print("\t[" + tupla[0] + "\t" + tupla[1] + "]");
//			}
					
			System.out.println("\n-->>CANTIDAD DE CAJAS DE AHORRO POR USUARIO:");
			List<Resultado1TO> resultados3 = bd.obtenerCantidadCajasAhorroPorUsuario();
			for (int i = 0; i < resultados.size(); i++) {
				System.out.println("\t" + resultados3.get(i));
			}
			
			System.out.println("\n-->>CUENTAS CORRIENTES");
			List<CuentaTO> ctaCorrientes = bd.obtenerCuentasCorrientes();
			for (int i = 0; i < ctaCorrientes.size(); i++) {
				System.out.println("\t"+ctaCorrientes.get(i));
			}
			
			System.out.println("\n-->>CUENTA CON MAYOR SALDO");
			CuentaTO cuenta = bd.obtenerCuentaConMayorSaldo();
			System.out.println("\t"+cuenta);
			
			System.out.println("\n-->>PERSONA DE LA LOCALIDAD DE WILDE");
			List<UsuarioTO> resulWild = bd.obtenerPersonaDeWilde();
			for (int i = 0; i < resulWild.size(); i++) {
				System.out.println(resulWild.get(i));
			}
			
			System.out.println("\n-->>CUENTA Y USUARIO CON SALDO 2300");
			List<Resultado1TO> resultado = bd.obtenerCuentaYUsuarioConSaldo2300(200);
			for (int i = 0; i < resultado.size(); i++) {
				System.out.println(resultado.get(i));
			}
			
			UsuarioTO uTO = new UsuarioTO("prueba@yahoo.com.ar", "Prueba", "Prueba");
			
			TelefonoTO tTO = new TelefonoTO();
			tTO.setArea(11);
			tTO.setNumero((new Random()).nextInt());
			tTO.setTipo("CELULAR");
			List<TelefonoTO> telefonos = new ArrayList<TelefonoTO>();
			telefonos.add(tTO);
			uTO.setTelefono(telefonos);
			
			DomicilioTO dTO = new DomicilioTO();
			dTO.setCodPost("1761");
			dTO.setDireccion("Del peru 2198");
			dTO.setLocalidad("Pontevedra");
			uTO.setDomicilio(dTO);
			
			CajaAhorroTO cTO = new CajaAhorroTO((double) 1233);
//			cTO.setSaldo(new Double(123));
			List<CuentaTO> cuentas = new ArrayList<CuentaTO>();
			cuentas.add(cTO);
			uTO.setCuentas(cuentas);
			
			System.out.println("\n-->>INSERTAR USUARIO");
			bd.insertarUsuario(uTO);
			System.out.println("\n-->>OK USUARIO INSERTADO");
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
