package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class Inserted {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Employee e = new Employee();
		e.setEmpId(127);
		e.setName("Ram");
		e.setCity("pune");
		e.setEmail("ram@gmail.com");

		
		Employee e1 = new Employee();
		e1.setEmpId(128);
		e1.setName("om");
		e1.setCity("mumbai");
		e1.setEmail("om@gmail.com");

//		ss.save(e);
		ss.persist(e);
		ss.persist(e1);

		System.out.println("inserted ...! ");

		tr.commit();
		ss.close();

	}

}