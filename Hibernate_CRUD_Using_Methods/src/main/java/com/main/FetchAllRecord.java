package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class FetchAllRecord {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		List<Employee> list = ss.createQuery("from Employee", Employee.class).list();

		for (Employee emp : list) {
			System.out.println(emp.getCity());
			System.out.println(emp.getEmail());
			System.out.println(emp.getName());
		}

		tr.commit();
		ss.close();
	}
}
