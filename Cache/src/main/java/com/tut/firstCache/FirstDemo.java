package com.tut.firstCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import secondCache.Student;

public class FirstDemo {
	public static void main(String[] args) {

		System.out.println("Project Started");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student st = (Student)session.get(Student.class, 1);
		System.out.println(st);
		
		
		//it tells whether the object is present in cache or not
		System.out.println(session.contains(st));
		
		
		
		
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}