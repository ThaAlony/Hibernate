package longobardo.giovanni.HibernateRelazioni;

import java.util.Collection;

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
        
    	
    	// CREO 2 STUDENTI e 3 LAPTOP
    	Studente s = new Studente();
    	s.setId(1);
    	s.setNome("Siro Soldick");
    	
    	Laptop l = new Laptop();
    	l.setId(1);
    	l.setNome("HP");
    	l.getStudente().add(s);
    	
    	s.getLaptop().add(l);
    	
    	Studente s2= new Studente();
    	s2.setId(2);
    	s2.setNome("Crazy Nighi Weeghi");
    	Laptop l2 = new Laptop();
    	l2.setId(2);
    	l2.setNome("Acer");
    	l2.getStudente().add(s2);
    	
    	
    	Laptop l3 = new Laptop();
    	l3.setId(3);
    	l3.setNome("Dell");
    	l3.getStudente().add(s2);
    	
    	
    	// AGGIUNTO 2 LAPTOP AD 1 STUDNTE
    	s2.getLaptop().add(l2);
    	s2.getLaptop().add(l3);
    	
    	
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Studente.class).addAnnotatedClass(Laptop.class);
    	
    	
    	SessionFactory sf = conf.buildSessionFactory();
    	Session session = sf.openSession();
    	
    	Transaction ts = session.beginTransaction();


    	// SALVO STUDENTI E LAPTOPS
    	session.persist(s);
    	session.persist(l);
    	session.persist(s2);
    	session.persist(l2);
    	session.persist(l3);
    	
    	
    	Studente stud = session.get(Studente.class, 2);
    	
    	
    	System.out.print(stud);
    	
    	
    	// LAZY FETCH ( viene fatta una SELECT dei laptop solo quando serve nel codice )
    	Collection<Laptop> laps = stud.getLaptop();
    	
    	for(Laptop lap : laps) {
    		System.out.print(lap);
    	}
    	
    	
    	ts.commit();
    	
    	
    
    }
}
