package longobardo.giovanni.Hibernate;

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
        System.out.println( "Hello World!" );
        
        AlienoNome aNome = new AlienoNome();
        aNome.setNome("Puma Puma");
        aNome.setCognome("Ci");
        Alieno a = new Alieno();
        a.setId(4);
        a.setNome(aNome);
        a.setColore("verde");
        
        
        Configuration conf = new Configuration().configure().addAnnotatedClass(Alieno.class);
        
        
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction ts = session.beginTransaction();
        //session.persist(a); // SALVA L'OGGETTO NEL DB
        session.persist(a);
        a= (Alieno) session.get(Alieno.class, 2);  // session.get ritorna un oggetto di tipo Object quindi si fa il casting
        ts.commit();
        
        
        System.out.print(a);
    }
}
