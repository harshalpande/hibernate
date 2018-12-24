package connection.jpa.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class ManyToManyUserDetails {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue
	private int id;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@ManyToMany
	@JoinTable(name="USER_VEHICLE_MAPPING",
		joinColumns=@JoinColumn(name="USER_ID"),
		inverseJoinColumns=@JoinColumn(name="VEHCILE_ID"))
	private Collection<ManyToManyVehicleDetails> vehicleList = new ArrayList<ManyToManyVehicleDetails>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<ManyToManyVehicleDetails> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(Collection<ManyToManyVehicleDetails> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
}
