package connection.jpa.cascading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestRun {

	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		
		vehicle1.setVehicleType("CAR");
		vehicle2.setVehicleType("Bike");
		
		UserDetails user = new UserDetails();
		user.setUserName("Harshal Pande");
		
		user.getListOfVehicle().add(vehicle1);
		user.getListOfVehicle().add(vehicle2);
		
		vehicle1.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.persist(user);			// save is replaced with Persist.
		/*session.save(vehicle1);
		session.save(vehicle2);*/
		
		session.getTransaction().commit();
		session.close();
	}

}
