package longobardo.giovanni.HbernateQueryLanguage;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	
    	
    	
    	Configuration conf = new Configuration().configure();
    	conf.addAnnotatedClass(Ninja.class);
    	SessionFactory sf = conf.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	/*
    	// INSERIMENTO
    	for(int i = 0; i<10;i++) {
    		Ninja n = new Ninja();
    		n.setId(i);
    		n.setNome("Chunin " + i);
    		n.setVillaggio("foglia");
    		session.save(n);
    	}for(int i = 10; i<20;i++) {
    		Ninja n = new Ninja();
    		n.setId(i);
    		n.setNome("Chunin " + i);
    		n.setVillaggio("sabbia");
    		session.save(n);
    	}for(int i = 20; i<30;i++) {
    		Ninja n = new Ninja();
    		n.setId(i);
    		n.setNome("Chunin " + i);
    		n.setVillaggio("pioggia");
    		session.save(n);
    	}
    	*/
    	
    	
    	
    	Query q;
    	q = session.createQuery("from Ninja where villaggio = 'pioggia'");
    	List<Ninja> l = q.list();
    	
    	for(Ninja n1 : l) {
    		System.out.println(n1);
    	}
    	
    	int num = 3;
    	q = session.createQuery("from Ninja where id = :id"); // PreparedStatement, mettendo : e poi il nome si crea un prepared statement
    	q.setParameter("id", num); // anziché mettere il numero del parametro mettiamo il nome
    	Ninja n2 = (Ninja) q.uniqueResult();
    	System.out.println(n2);
    	
    	q = session.createQuery("select nome,villaggio from Ninja n where n.id=14"); // E' bene specificare da che tabella prendiamo i campi messi nel where per evitare di fare JOIN accidentali
    	Object[] o = (Object[]) q.uniqueResult();  // Avendo selezionato le colonne non ritorna un oggetto Ninja ma un Array di oggetti di tipo Integer,String,Float etc
    	System.out.println("Nome : " + o[0] + " - Villaggio " + o[1]);


    	q = session.createQuery("select nome,villaggio from Ninja");
    	List<Object[]> l1 = (List<Object[]>) q.list();  // Non avendo messo il where non ritorna un singolo arrya ma una lista di array
    	for(Object[] o2 : l1) {
    		System.out.println("Nome : " + o2[0] + " - Villaggio " + o2[1]);
    	}
    	
    	NativeQuery sql = session.createNativeQuery("select * from ninja where villaggio = 'sabbia'"); // Possiamo usare SQL in Hibernate
    	sql.addEntity(Ninja.class); // SPECIFICHIAMO che l'output è di classe Ninja ( altrimenti sarebbe stato di tipo Object
    	List<Ninja> r = sql.list();
    	for(Ninja n1 : r) {
    		System.out.println(n1);
    	}
    	
    	NativeQuery sql2 = session.createNativeQuery("select nome from ninja where villaggio = 'foglia'"); 
    	sql2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); // TRANSFORMA l'output in una Mappa
    	List<Ninja> r2 = sql2.list();
    	for(Object ob : r2) {  // essendo più righe il risultato della query non è una mappa ma un array di mappe
    		Map m = (Map)ob;
    		System.out.println(m.get("nome"));
    	}
    	
    	session.getTransaction().commit();
    }
}
