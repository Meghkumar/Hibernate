package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started" );
        
        Configuration cfg = new Configuration();
        cfg.configure("/com/tut/hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student s = new Student();
        s.setId(3);
        s.setName("Ram");
        s.setCity("Navi Mumbai");
        System.out.println(s);
        
        Address ad = new Address();
        ad.setStreet("swarget");
        ad.setCity("Pune");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1212.3);
        
        
        //for image upload
        FileInputStream fi = new FileInputStream("src/main/java/comp.jpg");
        byte[] data = new byte[fi.available()];
        fi.read(data);
        ad.setImage(data);
        
        
        Session session = factory.openSession();
        Transaction tx= session.beginTransaction();
        
        session.save(s);
        session.save(ad);
        
        tx.commit();
        session.close();
       
        
        System.out.println("Done");
        
        
        
        
        
        	
        
        
        
        
        
        
    }
}
