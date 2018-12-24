package connection.jpa.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import connection.jpa.model.UserDetailsOneOne;
import connection.jpa.model.VehicleDetails;

public class OnetoOneTest {
	
	public static void main(String[] args) {
		UserDetailsOneOne user = new UserDetailsOneOne();
		VehicleDetails vehicle = new VehicleDetails();
		
		vehicle.setVehicleType("Car");
		user.setUser_name("harshal Pande");
		user.setVehicleDetails(vehicle);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}

}
