package com.tut.one_Many;

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
		Session session = factory.openSession();

		Questions q1 = new Questions();
		q1.setQuestion_id(3);
		q1.setQuestions("What is java");

		Answers ans1 = new Answers();
		ans1.setAnswer_Id(11);
		ans1.setAnswers("Java is programming language");
		ans1.setQuestions(q1);

		Answers ans2 = new Answers();
		ans2.setAnswer_Id(12);
		ans2.setAnswers("With the help of java we can create applications");
		ans2.setQuestions(q1);

		Answers ans3 = new Answers();
		ans3.setAnswer_Id(13);
		ans3.setAnswers("Java has different types of frameworks");
		ans3.setQuestions(q1);

		List<Answers> list = new ArrayList<Answers>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		q1.setAnswers(list);

		Transaction tx = session.beginTransaction();

		session.save(q1);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);

		tx.commit();
		session.close();
		factory.close();
		System.out.println("done");
		
	}
}
