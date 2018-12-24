package connection.jpa.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE_DETAILS")
public class ManyToManyVehicleDetails {
	
	@Id
	@GeneratedValue
	@Column(name="VEHCILE_ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	
	@ManyToMany(mappedBy="vehicleList")
	private Collection<ManyToManyUserDetails> userList = new ArrayList<ManyToManyUserDetails>();

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Collection<ManyToManyUserDetails> getUserList() {
		return userList;
	}

	public void setUserList(Collection<ManyToManyUserDetails> userList) {
		this.userList = userList;
	}
}
