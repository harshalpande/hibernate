package connection.jpa.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import connection.jpa.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();

		user.setUserId(2);
		user.setUserName("Snehal");
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (HibernateException exception) {
			exception.printStackTrace();
		}
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
	}

}
