package com.main;

import org.hibernate.cfg.Configuration;
import com.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Update {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int id = 127;
		Employee e1 = ss.get(Employee.class, id);
		e1.setName("Priya");
		e1.setCity("Mumbai");
		e1.setEmail("priya@gmail.com");

		// ss.update(e1);
		ss.merge(e1);

		System.out.println("Updated!....");
		tr.commit();
		ss.close();

	}
}
