package connection.jpa.namedqueries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

/**
 * if resultClass is not mentioned when we will get hibernate native query
 * @NotYetSupportedException for @NamedNativeQuery with Native SQL Query
 */
@Entity
@NamedQuery(
		name = "UserDetails.byId", 
		query = "from UserDetails where id > :userId"		// HQL query
		)
@NamedNativeQuery(
		name = "UserDetails.byName", 
		query = "select * from USERDETAILS where name = :userName", 	// Sql Query
		resultClass = UserDetails.class			// Mentioned Output Type
		)
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
