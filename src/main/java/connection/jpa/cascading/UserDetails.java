package connection.jpa.cascading;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String userName;

	/**
	 * cascade is used when there are a lot of objects present and it would be very
	 * cumbersome for the user to write this line (session.save(obj)); to save each
	 * one of them. Hence we can use property cascade = CascadeType.Persist (persist
	 * = save) available only for OneToMany or ManyToOne annotations scenario. Also
	 * save method api is replaced with persist in main method
	 */

	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private Collection<Vehicle> listOfVehicle = new ArrayList<Vehicle>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Vehicle> getListOfVehicle() {
		return listOfVehicle;
	}
}
