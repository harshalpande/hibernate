package connection.jpa.namedqueries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NamedQueriesTest {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		//Query query = session.getNamedQuery("UserDetails.byId");
		Query query = session.getNamedQuery("UserDetails.byName");
		
		query.setString("userName", "Harshal Pande");
		
		List<UserDetails> users = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails user : users) {
			System.out.println(user.getId() + " : " + user.getName());
		}
	}

}
