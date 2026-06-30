package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import com.entity.Employee;

public class Deleted {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		// Select * from Employee where id=128
		String hqlQuery = "delete from Employee where id=: id";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("id", 128);
		int check = query.executeUpdate();
		if (check > 0) {
			System.out.println("Deleted ...! ");
		} else {
			System.out.println("Data is not Present....");
		}
		tr.commit();
		ss.close();

	}

}