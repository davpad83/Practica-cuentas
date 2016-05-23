package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import dominio.CajaAhorro;
import dominio.Cuenta;
import dominio.CuentaCorriente;
import dominio.Telefono;
import dominio.TelefonoId;
import dominio.Usuario;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(Usuario.class);
        	 config.addAnnotatedClass(Telefono.class);
        	 config.addAnnotatedClass(TelefonoId.class);
        	 config.addAnnotatedClass(CajaAhorro.class);
        	 config.addAnnotatedClass(CuentaCorriente.class);
        	         	 
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
