package secondCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;



public class SecondCacheExample {


	public static void main(String[] args) {


		System.out.println("Project Started");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// first session
		Session session1 = factory.openSession();
		Student student1 = session1.get(Student.class, 1);
		System.out.println(student1);
		session1.close();

		// second session
		Session session2 = factory.openSession();
		Student student2 = session1.get(Student.class, 1);
		System.out.println(student2);
		session2.close();

	}
}
