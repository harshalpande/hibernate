package connection.hibernate.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLTest {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();
		
		/*for (int i = 0; i < 10 ; i ++) {
			UserDetails user = new UserDetails();
			user.setName("user " +  i);
			session.save(user);
		}*/

		Integer count = 3;
		
		//---------- Way 1 : using placeholder String method :_STR ----------------------------------
		
		/*Query query = session.createQuery("from UserDetails where id > :hbID AND name = :hbName");

		query.setString("hbName", "Harshal Pande");
		query.setInteger("hbID", count);*/
		
		//---------- Way 2 : using placeholder '?' method  ----------------------------------
		Query query = session.createQuery("from UserDetails where id > ? AND name = ?");

		query.setInteger(0, count);				// 0 means 0th ? in the above query
		query.setString(1, "Harshal Pande");	// 0 means 1st ? in the above query
		
		UserDetails user = (UserDetails) query.list().get(0);

		session.getTransaction().commit();
		session.close();

		System.out.println(user.getId() + ":" + user.getName());
	}

}
