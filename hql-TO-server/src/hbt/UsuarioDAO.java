package hbt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.Domicilio;
import dominio.Usuario;
import dominio.dto.CuentaTO;
import dominio.dto.Resultado1TO;
import dominio.dto.UsuarioTO;

public class UsuarioDAO {
	protected static UsuarioDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;

	
	public static UsuarioDAO getInstancia(){
		if(instancia == null){
			instancia = new UsuarioDAO();
		} 
		return instancia;
	}
	
	protected UsuarioDAO()  {
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
	
//	@SuppressWarnings("rawtypes")
//	public Object get (Class c, Object o) {
//		Session session = getSession();
//		return session.get(c, (Serializable) o);
//	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios(){
		
		Session session = getSession();
		String query = "from Usuario";
		List<Usuario> usuarios = session.createQuery(query).list();
		closeSession();
		return usuarios;
	}
	
	public Usuario obtenerUsuario(UsuarioTO dto) {
		
		Session session = getSession();
		String query = "from Usuario usu where usu.apellido = :apellido";
		Usuario usuario = (Usuario) session.createQuery(query).setProperties(dto).uniqueResult();
		closeSession();
		return usuario;
	}

	public Long obtenerCantidadUsuarios() {
		Session session = getSession();
		String query = "select count(*) from Usuario";
		Long cantidad = (Long) session.createQuery(query).uniqueResult();
		closeSession();
		return cantidad;
	}

	@SuppressWarnings("unchecked")
	public List<Resultado1TO> obtenerCantidadCuentasPorUsuario() {

		Session session = getSession();
		String query = "select new List(usu.apellido, count(cta) as cantidad) from Usuario usu left join usu.cuentas cta group by usu.apellido";
		List<Resultado1TO> resultados = (List<Resultado1TO>) session.createQuery(query).list();
		closeSession();
		return resultados;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> obtenerCantidadCuentasPorUsuario2() {

		Session session = getSession();
		String query = "select usu.apellido, count(cta) as cantidad from Usuario usu left join usu.cuentas cta group by usu.apellido";
		List<Object[]> lista = session.createQuery(query).list();
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Resultado1TO> obtenerCantidadCajasAhorroPorUsuario(){
		
		Session s = getSession();
		String query = "select new List(usu.apellido, count(cue) as cantidad) from Usuario usu inner join usu.cuentas cue where cue.class = CajaAhorro group by usu.apellido";
		List<Resultado1TO> resultados = (List<Resultado1TO>) s.createQuery(query).list();
		return resultados;
		
	}

	@SuppressWarnings("unchecked")
	public List<CuentaTO> obtenerCuentasCorrientes() {
		Session s = getSession();
		String query = "select new List(cue.saldo, cue.fechaCreacion)from Cuenta cue where cue.class = CuentaCorriente";
		List<CuentaTO> resultados = (List<CuentaTO>) s.createQuery(query).list();
		
		return resultados;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerPersonaDeWilde() {
		Session s = getSession();

		String query = "select distinct(usu) from Usuario usu left join usu.cuentas cue where usu.domicilio.localidad = :localidad" +
						" and 0 < (select count(cue2) from Usuario usu2 left join usu2.cuentas cue2 where usu.id = usu2.id and cue2.class = CajaAhorro and cue2.saldo>10000)" +
						" and 0 = (select count(cue2) from Usuario usu2 left join usu2.cuentas cue2 where usu.id = usu2.id and cue2.class = CuentaCorriente)";

		Domicilio domicilio = new Domicilio();
		domicilio.setLocalidad("Wilde");

		List<Usuario> usuarios = (List<Usuario>) s.createQuery(query).setProperties(domicilio).list();
		
		return usuarios;
	}

	public List<Resultado1TO> obtenerCuentaYUsuaroConSaldo2300(int saldo) {
	
		Session s = getSession();
		String query = "select new List(usu.apellido, count(cue) as cantidad) from Usuario usu left join usu.cuentas cue where cue.saldo = :saldo group by usu.apellido";
		Double saldoDouble = Double.parseDouble(Long.toString(saldo));
		List<Resultado1TO> resultado = (List<Resultado1TO>) s.createQuery(query).setParameter("saldo", saldoDouble).list();
		
//		String query = "select usu.apellido, count(cue) from Usuario usu left join usu.cuentas cue where cue.saldo = :saldo group by usu.apellido";
//		Double saldoDouble = Double.parseDouble(Long.toString(saldo));
//		Object resultado =  s.createQuery(query).setParameter("saldo", saldoDouble).uniqueResult();
		
		return resultado;
	}

	public void insertarUsuario(Usuario usuario) {
		Session session = getSession();
		session.beginTransaction();
		session.persist(usuario);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
}
