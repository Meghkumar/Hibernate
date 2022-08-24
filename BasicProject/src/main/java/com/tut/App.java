package com.tut;

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
        System.out.println( "Project Started" );
        
        Configuration cfg = new Configuration();
        cfg.configure("/com/tut/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student st = new Student();
        st.setId(2);
        st.setName("Amit");
        st.setCity("New Panvel");
        
        System.out.println(st);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(st);
        
        tx.commit();
        session.close();
    
        
        
        
        
        
        
        
        	
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
