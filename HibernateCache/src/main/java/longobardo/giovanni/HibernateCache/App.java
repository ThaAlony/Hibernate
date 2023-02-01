package longobardo.giovanni.HibernateCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        

    	Criceto c = new Criceto();
    	c.setId(1);
    	c.setNome("Hamtaro");
    	c.setSesso('M');

    	Criceto c2 = new Criceto();
    	c2.setId(2);
    	c2.setNome("Bijou");
    	c2.setSesso('F');
    	
    	Criceto c3 = new Criceto();
    	c3.setId(3);
    	c3.setNome("Panda");
    	c3.setSesso('m');
    	
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Criceto.class);
    	
    	
    	SessionFactory sf = conf.buildSessionFactory();
    	Session session = sf.openSession();  //SESSIONE SOLO PER IL CARICAMENTO DEI CIRCETI NEL DB
    	
    	Transaction ts = session.beginTransaction();

    	session.persist(c);
    	session.persist(c2);
    	session.persist(c3);
    	
    	
    	ts.commit();
session.close();
    	
    	Session session2 = sf.openSession();   
    	
    	ts = session2.beginTransaction();
    	
    	System.out.println((Criceto) session2.get(Criceto.class, 2)); // VIENE ESEGUITA LA QUERY 
    	
    	ts.commit();
    	session2.close();
    	
    	Session session3 = sf.openSession();   // QUESTA SESSIONE NON HA ACCESSO ALLA FirstLevel Cache della session precedente! 	
    	
    	ts = session3.beginTransaction();
    	
    	System.out.println((Criceto) session3.get(Criceto.class, 2)); // VIENE DI NUOVO ESEGUITA LA QUERY FATTA NELLA SESSIONE PRECEDENTE
    	
    	ts.commit();
    	session3.close();
    
    	
    	// COME FUNZIONA LA CACHE CON LE CUSTOM QUERY?
    	
    	Session session4 = sf.openSession();   
    	
    	ts = session4.beginTransaction();
    	
    	Query q1 = session4.createQuery("from Criceto where id=1");  // QUESTO E' HQL, linguaggio di query di hibernate ( *vedi prossimo progetto* )
    	
    	Criceto r = (Criceto) q1.uniqueResult();
    	ts.commit();
    	session4.close();
    	
    	Session session5 = sf.openSession();   
    	
    	ts = session5.beginTransaction();
    	
    	Query q2 = session5.createQuery("from Criceto where id=1");
    	
    	Criceto r2 = (Criceto) q2.uniqueResult();
    	ts.commit();
    	session5.close();
    	
    	
    }
}
