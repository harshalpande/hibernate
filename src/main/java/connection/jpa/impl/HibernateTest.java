package connection.jpa.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import connection.jpa.model.Address;
import connection.jpa.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		Address addr1 = new Address();
		
		addr1.setBuilding("B902-Tatva Apartment");
		addr1.setStreet("Old Mundhwa-Kharadi Road");
		addr1.setCity("PUNE");
		addr1.setState("Maharashtra");
		addr1.setPincode("411014");
		
		user.setAddress(addr1);
		/*
		 * User_id is now annotated with Generated Value hence its value is not needed
		 * to be sent. it will be generated automatically by hibernate.
		 */
		// user.setUserId(1);
		
		user.setUserName("Harshal");
		user.setJoiningDate(new Date());
		user.setDescription("Large Text when used....");
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
		
		

		// Fetch values from DB-table
		user = null;
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		user = (UserDetails) session2.get(UserDetails.class, 1);
		System.out.println("Name :" + user.getUserName());
		System.out.println("Date of Joining :" + user.getJoiningDate());
		System.out.println("Address :" + user.getAddress());
		session2.close();
	}

}
