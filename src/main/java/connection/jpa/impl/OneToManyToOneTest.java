package connection.jpa.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import connection.jpa.model.OneToManyToOneUserDetails;
import connection.jpa.model.OneToManyToOneVehicleDetails;

public class OneToManyToOneTest {

	public static void main(String[] args) {
		OneToManyToOneUserDetails user = new OneToManyToOneUserDetails();

		user.setUserName("Harshal Pande");

		OneToManyToOneVehicleDetails vehicle = new OneToManyToOneVehicleDetails();
		OneToManyToOneVehicleDetails vehicle2 = new OneToManyToOneVehicleDetails();

		vehicle.setVehicleType("Car");
		vehicle.setUser(user);
		vehicle2.setVehicleType("Bike");
		vehicle2.setUser(user);
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);

		session.getTransaction().commit();
		session.close();
	}

}
