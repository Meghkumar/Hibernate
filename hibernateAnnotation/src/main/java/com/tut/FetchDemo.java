package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("com/tut/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		//By using GET option 
		Student st =(Student) session.get(Student.class, 2);
		
		// By using LOAD option
		Address ad = (Address)session.get(Address.class, 1);
		System.out.println(ad.getCity()+" , "+ad.getStreet());
		
		System.out.println(st);
		
		session.close();
		factory.close();
		
		
	}

}
