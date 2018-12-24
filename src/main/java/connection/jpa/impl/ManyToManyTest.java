package connection.jpa.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import connection.jpa.model.ManyToManyUserDetails;
import connection.jpa.model.ManyToManyVehicleDetails;

public class ManyToManyTest {
	
	public static void main(String[] args) {
		
		ManyToManyUserDetails user = new ManyToManyUserDetails();
		ManyToManyUserDetails user2 = new ManyToManyUserDetails();
		
		ManyToManyVehicleDetails vehicle = new ManyToManyVehicleDetails();
		ManyToManyVehicleDetails vehicle2 = new ManyToManyVehicleDetails();
		
		user.setUserName("Harshal");
		user2.setUserName("Jatin");
		
		vehicle.setVehicleType("Bike");
		vehicle2.setVehicleType("car");
		
		user.getVehicleList().add(vehicle);
		user.getVehicleList().add(vehicle2);
		
		user2.getVehicleList().add(vehicle);
		
		vehicle.getUserList().add(user);
		vehicle.getUserList().add(user2);
		
		vehicle2.getUserList().add(user);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(user); 
		session.save(user2);
		session.save(vehicle);
		session.save(vehicle2);
		
		session.getTransaction().commit();
		session.close();
		
		
		
		
		
	}
}
