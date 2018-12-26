package connection.jpa.inheritance.strategy.single;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestRun { 
	
	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Haath-Gaadi");
		
		FourWheeler fourWheeler = new FourWheeler();
		TwoWheeler twoWheeler = new TwoWheeler();
		
		fourWheeler.setVehicleName("Renault");
		fourWheeler.setSteering("Kwid");
		
		twoWheeler.setVehicleName("Honda");
		twoWheeler.setHandle("Dazzler");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(fourWheeler);
		session.save(twoWheeler);
		
		session.getTransaction().commit();
		session.close();
	}
}
