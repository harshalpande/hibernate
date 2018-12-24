package connection.jpa.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class OneToManyToOneUserDetails {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;

	
	/**
	 * using basic OneToMany and ManyToOne creates a different table for mapping, 
	 * however in some scenarios, this seperate mapping table is not required. 
	 * for e.g. User can have many vehicles(OneToMany), but vehicle can have only one user (ManyToOne)
	 * so we can eliminate seperate mapping table by creating a new COLUMN User_ID in Vehicle table. 
	 * This can be done by using property 'mappedBy', where we have to specify in the source table class
	 * where we have to do the mapping. here we have to do mapping in Vehicle Table by specifying User_ID 
	 * column, hence the property will be mentioned in User Table like below.
	 * */
	@OneToMany(mappedBy="user")
	private Collection<OneToManyToOneVehicleDetails> vehicle = new ArrayList<OneToManyToOneVehicleDetails>();;
	
	public Collection<OneToManyToOneVehicleDetails> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<OneToManyToOneVehicleDetails> vehicle) {
		this.vehicle = vehicle;
	}

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
	
}
