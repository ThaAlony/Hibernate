package longobardo.giovanni.HibernateRelazioni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Studente s = new Studente();
    	s.setId(1);
    	s.setNome("Siro Soldick");
    	
    	Laptop l = new Laptop();
    	l.setId(1);
    	l.setNome("HP");
    	l.setStudente(s);
    	
    	s.setLaptop(l);
    	
    	
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Studente.class).addAnnotatedClass(Laptop.class);
    	
    	
    	SessionFactory sf = conf.buildSessionFactory();
    	Session session = sf.openSession();
    	
    	Transaction ts = session.beginTransaction();
    	
    	session.persist(s);
    	session.persist(l);
    	
    	
    	ts.commit();
    }
}
