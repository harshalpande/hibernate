package connection.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Example of Embeddable Annotation to demonsterate Value Object. We can create
 * different class and Objects to store different values and that object can be
 * added to original class.
 * 
 * While seeing table you will never get to know that since we have 2 different
 * class, we will get 2 different tables, we will get one table and other fields
 * will be embedded into the master class table like its own columns.
 * 
 * @author pandehar
 *
 */
@Embeddable
public class Address {
	
	@Column(name = "BUILDING")
	private String building;

	@Column(name = "STREET")
	private String street;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "PIN_CODE")
	private String pincode;

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


}
