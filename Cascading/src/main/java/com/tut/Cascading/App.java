package com.tut.Cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("Project started");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();

		Questions que = new Questions();
		que.setQuestion_id(121);
		que.setQuestions("What is Cascading");

		Answers ans1 = new Answers(1221,"Java is programming language");
		Answers ans2 = new Answers(1222,"Second answer");
		Answers ans3 = new Answers(1223,"Third answer");

		List<Answers> list = new ArrayList<Answers>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		
		que.setAnswers(list);

		Transaction tx = s.beginTransaction();

		//By the help of cascading we dont need to save the answers separately
		s.save(que);
	
		

		tx.commit();
		s.close();
		factory.close();
		System.out.println("done");
		
	}}

