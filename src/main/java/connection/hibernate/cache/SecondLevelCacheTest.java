package connection.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 1 level cache is already being present with Hibernate and it is doing its
 * job. Whenever 2 CRUD operations are being performed in a single session then
 * we can clearly see that only one transction is performed over a table in the
 * console. However the same is not true when Same query is being fired more
 * than once in more than once session. So for e.g. 2 exactly same select
 * queries are being performed in 2 different sessions then 2 SQL queries are
 * being fired, which is not so efficient. Hence we can configure Second Level
 * Cache in hibernate and we can choose from different Cache providers and
 * configure that in hibernate.cfg.xml file. We have to annotate the MODEL java
 * file with @Cache(strategy property as well) and @Cacheable to achieve the
 * same effect as single level cache.
 * 
 * Here the 2nd Level cache that is being configured in hibernate.cfg.xml is
 * EH-CACHE. There are some more as well available. I downloaded the EHCACHE
 * dependency and HIBERNATE-ENcache dependency from Central Maven repository
 * configured in POM.XML.
 * 
 * @author Harshal S Pande
 *
 */
public class SecondLevelCacheTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// First Session Object
		Session session = factory.openSession();
		session.beginTransaction();

		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();

		// Second Session Object
		Session session2 = factory.openSession();
		session2.beginTransaction();

		UserDetails anotherUser = (UserDetails) session.get(UserDetails.class, 1);

		session2.getTransaction().commit();
		session2.close();
	}
}
