package com.main;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

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

		String hqlQuery = "update Employee set city=: city where id=: id";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("id", 128);
		query.setParameter("city", "Goa");
		query.executeUpdate();

		System.out.println("Updated!....");
		tr.commit();
		ss.close();

	}
}
