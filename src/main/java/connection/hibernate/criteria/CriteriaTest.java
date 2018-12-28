package connection.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * One of the ways to fire query over a database is by using Criteria and
 * Restriction API's of HIBERNATE framework.
 * 
 * @Criteria - works just like Query Api and
 * @Restriction works like WHERE clause of a query.
 * 
 *              Adding multiple Restrictions by appending .ADD(RESTRICTION
 *              PARAM) will lead to query getting more and more restricted just
 *              like AND clause in Query. for e.g. * Select * from TABLE where
 *              USER_NAME = "ABC" @AND USER_ID > 10
 * 
 * @Restriction - OR clause in the query can be used by
 *              using @Restriction.OR(lhs, rhs) api.
 * 
 * @author pandehar
 *
 */
public class CriteriaTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDetails.class);

		/**
		 * below criteria multiple .add api works just like AND operation in SQL query
		 * @OUTPUT - 
		 * 			8 : user 7
		 * 			9 : user 8
		 * 			10 : user 9
		 *
		 */
		/*criteria.add(Restrictions.like("name", "user%"))
				.add(Restrictions.gt("id", 7));*/
		
		/**
		 * below Restrictions are added just like sql OR clause which means either 
		 * this condition will satisfy or that, but you will get the result. 
		 * if both are true then you will get combination of both results
		 * 
		 * OUTPUT - 
		 * 			7 : user 6
		 * 			5 : Harshal Pande
		 * */
		criteria.add(Restrictions.or(
				Restrictions.eq("id", 5), 
				Restrictions.eq("id", 7)));

		List<UserDetails> users = criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails user : users) {
			System.out.println(user.getId() + " : " + user.getName());
		}

	}

}
