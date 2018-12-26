package connection.jpa.inheritance.strategy.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @Inheritance(strategy=InheritanceType.JOINED) This is required to mention,
 *                                               because it is by understood by
 *                                               hibernate that you are trying
 *                                               to implement a JOINED strategy
 *                                               wherein each class object will
 *                                               have seperate table but
 *                                               reference column will also be
 *                                               present so that User can
 *                                               perform join query and collect
 *                                               data. This is the best and most
 *                                               NORMALIZED strategy of table
 *                                               structure in a database.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String vehicleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
