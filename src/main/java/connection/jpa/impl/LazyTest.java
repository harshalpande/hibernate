package connection.jpa.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import connection.jpa.model.UserDetailsNormalized;

public class LazyTest {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetailsNormalized userDetails = null;
		userDetails = (UserDetailsNormalized)session.get(UserDetailsNormalized.class, 1);
		session.close();
		System.out.println(userDetails.getListOfAddress().size());
	}

}
