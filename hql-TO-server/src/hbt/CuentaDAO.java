package hbt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.Cuenta;

public class CuentaDAO {
	protected static CuentaDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;

	
	public static CuentaDAO getInstancia(){
		if(instancia == null){
			instancia = new CuentaDAO();
		} 
		return instancia;
	}
	
	protected CuentaDAO()  {
		sf = HibernateUtil.getSessionFactory();
	}

	protected Session getSession(){
		if(session == null || !session.isOpen()){
			session = sf.openSession();
		}
		return session;
	}
	
	public void closeSession(){
		if (session.isOpen()) {
			session.close();
		}
	}

	public Cuenta obtenerCuentaConMayorSaldo() {
		Session s = getSession();
		String query = "select cta from Cuenta cta where cta.saldo = (select max(saldo) from Cuenta)";
		Cuenta cuenta = (Cuenta) s.createQuery(query).uniqueResult();
		return cuenta;
	}
	
	
	
	
	
	
}
