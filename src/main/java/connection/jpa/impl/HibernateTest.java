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

		Address addrHome = new Address();

		addrHome.setBuilding("B902-Tatva Apartment");
		addrHome.setStreet("Old Mundhwa-Kharadi Road");
		addrHome.setCity("PUNE");
		addrHome.setState("Maharashtra");
		addrHome.setPincode("411014");

		user.setHomeAddress(addrHome);

		Address addrOffice = new Address();

		addrOffice.setBuilding("Tieto India Pvt Ltd");
		addrOffice.setStreet("EON Free Zone IT Park");
		addrOffice.setCity("PUNE");
		addrOffice.setState("Maharashtra");
		addrOffice.setPincode("411014");
		
		user.setOfficeAddress(addrOffice);
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
		System.out.println("Address :" + user.getHomeAddress() +"\n"+ user.getOfficeAddress());
		session2.close();
	}

}
