package longobardo.giovanni.HibernateObjectState;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	// STATI IN HIBERNATE
    	/*
    	 * Transient: l'oggetto esiste ma non è legato a nessuna entità nel database, per cui verrà cestinato una volta terminato il processo
    	 * Persistent:  l'oggetto esiste ed è legato ad una entità nel DB, ogni operazione che faremo con esso verrà automatiamente replicata nel DB
    	 * Detached: l'oggetto era legato ad una entità nel DB ma adesso no, per cui verrà cestinato (utile se vogliamo evitare di far inviare numorse query ogni volta che facciamo un operazione su questo oggetto ma ne vogliamo inviare solo una alla fine)
    	 * Removed: l'oggetto esiste ma abbiamo eliminato la sua entità nel DB, per cui verrà cestinato
    	 */
        
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Pacco.class);
    	SessionFactory sf = conf.buildSessionFactory();
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	Pacco p = new Pacco();          // lo stato di questo oggetto è Transient
    	p.setId(1);
    	p.setStato("Da processare");
    	
    	session.persist(p); // lo stato di questo oggetto è Persistent ( MA VERRA' SALVATO SOLO DOPO IL COMMIT!!)
    	
    	p.setStato("Da Spedire"); // essendo persistent, nel db verrà salvato come "Da Spedire"
    	
    	session.getTransaction().commit();
    	
    	session.beginTransaction();
    	session.detach(p); // ora è in detached ( lo puoi fare solo DOPO che l'oggetto è stato salvato
    	p.setStato("Spedito"); // Questi cambiamenti NON verranno salvati	
    	
    	
    	session.remove(p);   // ora è in Removed, viene cancellato dal DB
    	session.getTransaction().commit();
    }
}
