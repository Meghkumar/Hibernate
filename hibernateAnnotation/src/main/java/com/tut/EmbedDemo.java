package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("com/tut/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		
		Student student1 = new Student();
		student1.setId(101);
		student1.setName("Ravi");
		student1.setCity("Delhi");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Android");
		certificate1.setDuration("2 months");
		student1.setCerti(certificate1);
		
		Student student2 = new Student();
		student2.setId(102);
		student2.setName("Shiva");
		student2.setCity("Pune");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Java");
		certificate2.setDuration("4 months");
		student2.setCerti(certificate2);
		
		Transaction tx = session.beginTransaction();
		
		
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		session.close();
		factory.close();
		
		
	}

}
