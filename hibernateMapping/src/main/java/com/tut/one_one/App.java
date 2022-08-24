package com.tut.one_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started" );
        
        
        Configuration cfg = new Configuration();
		cfg.configure("com/tut/one_one/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		
		
		Questions q1 = new  Questions();
		q1.setQuesrtion_id(1);
		q1.setQuestions("What is java");
		
		Answers ans1 = new Answers();
		ans1.setAnswer_Id(11);
		ans1.setAnswers("Java is programming language");
		ans1.setQuestions(q1);
		q1.setAnswers(ans1);
		
		
		Questions q2 = new  Questions();
		q2.setQuesrtion_id(2);
		q2.setQuestions("What is collection framework");
		
		Answers ans2 = new Answers();
		ans2.setAnswer_Id(22);
		ans2.setAnswers("It is API to work with Objects with java");
		ans2.setQuestions(q2);
		q2.setAnswers(ans2);
		
		Transaction tx = session.beginTransaction();
		
		
		session.save(q1);
		session.save(q2);
		session.save(ans1);
		session.save(ans2);
		
		
		tx.commit();
		session.close();
		factory.close();
		System.out.println("done");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
    }
}
