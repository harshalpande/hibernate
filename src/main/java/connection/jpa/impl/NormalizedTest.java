package connection.jpa.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import connection.jpa.model.Address;
import connection.jpa.model.UserDetailsNormalized;

public class NormalizedTest {

	public static void main(String[] args) {
		UserDetailsNormalized userDetails = new UserDetailsNormalized();

		userDetails.setUserName("Harshal Pande");
		
		Address homeAddress = new Address();

		homeAddress.setBuilding("B902-Tatva Apartment");
		homeAddress.setStreet("Old Mundhwa-Kharadi Road");
		homeAddress.setCity("PUNE");
		homeAddress.setState("Maharashtra");
		homeAddress.setPincode("411014");

		userDetails.getListOfAddress().add(homeAddress);

		Address officeAddress = new Address();

		officeAddress.setBuilding("Tieto India Pvt Ltd");
		officeAddress.setStreet("EON Free Zone IT Park");
		officeAddress.setCity("PUNE");
		officeAddress.setState("Maharashtra");
		officeAddress.setPincode("411014");

		userDetails.getListOfAddress().add(officeAddress);
		
		Address mainAddress = new Address();

		mainAddress.setBuilding("2/1 Shreeniwas Blgd");
		mainAddress.setStreet("Kisan Nagar 3, Road no 16");
		mainAddress.setCity("Thane");
		mainAddress.setState("Maharashtra");
		mainAddress.setPincode("400604");

		userDetails.getListOfAddress().add(mainAddress);

		/* This is hibernate code for triggering a transaction. */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
	}

}
