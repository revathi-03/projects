package rev.nan;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

 
public class hibernateDemo {
	


	public static void main(String args[]) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	    
	    SessionFactory sf = meta.getSessionFactoryBuilder().build();
	    Session session = sf.openSession();
	    org.hibernate.Transaction txn = session.beginTransaction();
	    
	    Employee e1= new Employee();
	    e1.setId(1);
	    e1.setFname("Revathi");
	    e1.setLname("senapathi");
	    e1.setCity("vizag");
	    
	    session.save(e1);
	    txn.commit();
	    
	    
	}


	

}
