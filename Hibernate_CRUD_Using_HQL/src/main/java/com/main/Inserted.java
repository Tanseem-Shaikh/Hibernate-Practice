package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Employee;

public class Inserted {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "insert into Employee(empId,city,email,name) values(:empId,:city,:email,:name)";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("empId", 101);
		query.setParameter("city", "Latur");
		query.setParameter("email", "tanseem@gmail.com");
		query.setParameter("name", "Tanseem");
		query.executeUpdate();

		System.out.println("inserted ...! ");

		tr.commit();
		ss.close();

	}

}