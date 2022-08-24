package com.tut.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("project started");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		
		e1.setEid(1);
		e1.setName("Ram");
		
		e2.setEid(2);
		e2.setName("Sham");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		
		p1.setPid(101);
		p1.setProjectName("Library Management System");
		
		p2.setPid(102);
		p2.setProjectName("ChatBot");
		
		
		List<Emp> list1 = new ArrayList();
		List<Project> list2 = new ArrayList();
		
		
		list1.add(e1);
		list1.add(e2);

		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p1.setEmp(list1);
		
		
		Transaction tx = session.beginTransaction();
		
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		//get data
		Emp emp = (Emp)session.get(Emp.class, 2);
		for (Project p: list2) {
			System.out.println(p.getPid()+" = "+p.getProjectName());
		}
		
		
		tx.commit();
		session.close();
		factory.close();
		
		System.out.println("Done");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
