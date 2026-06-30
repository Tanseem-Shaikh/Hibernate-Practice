package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.entity.Employee;

public class FetchSinglrRecord {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Employee e = ss.get(Employee.class, 128);
		System.out.println(e.getCity());
		System.out.println(e.getEmail());
		System.out.println(e.getName());

		tr.commit();
		ss.close();

	}
}
