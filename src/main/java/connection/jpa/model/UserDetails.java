package connection.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)			// Auto Increment Column in a Table - Does not need to set value 
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "JOINING_DATE")
	private Date joiningDate;
	
	//@Basic() - to be used if we need to use its parameter otherwise using it alone doesn't make any effect
	// LOB - LargeObject
	
	@Lob
	@Column(name = "DESCRIPTION")
	private String description;

	
	
	/**
	 * to define that this is embedded here in USER_DETAILS class. This annotation is not required
	 */
	@Embedded
	private Address address;
	
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

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
