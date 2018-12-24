package connection.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLES")
public class OneToManyToOneVehicleDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	
	private String vehicleType;

	@ManyToOne
	private OneToManyToOneUserDetails user;
	
	public OneToManyToOneUserDetails getUser() {
		return user;
	}

	public void setUser(OneToManyToOneUserDetails user) {
		this.user = user;
	}

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
	
}
