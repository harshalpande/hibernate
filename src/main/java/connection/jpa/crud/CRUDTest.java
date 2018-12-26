package connection.jpa.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDTest {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		// Create
		//createNewUsers(session);
		
		// Get
		UserDetails user = getSpecificUser(session);
		
		// Delete
		//deleteSpecificUser(session, user);
		
		// Update
		updateSpecificValue(session, user);
		
		session.getTransaction().commit();
		session.close();
	}

	private static void updateSpecificValue(Session session, UserDetails user) {
		user.setName("Harshal Pande");
		session.update(user);
	}

	private static void deleteSpecificUser(Session session, UserDetails user) {
		session.delete(user);
	}

	private static UserDetails getSpecificUser(Session session) {
		UserDetails user = new UserDetails();

		user = (UserDetails) session.get(UserDetails.class, 5);
		System.out.println(user.getName());
		return user;

	}

	private static void createNewUsers(Session session) {
		UserDetails user;
		for (int i = 0; i < 10; i ++) {
			user = new UserDetails();
			user.setName("Name " + i);
			session.save(user);
		}
	}
}
