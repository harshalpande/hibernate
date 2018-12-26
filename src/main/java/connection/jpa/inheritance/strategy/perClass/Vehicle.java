package connection.jpa.inheritance.strategy.perClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) This is required to
 *                                                        mention, because it is
 *                                                        by understood by
 *                                                        hibernate that you are
 *                                                        trying to implement a
 *                                                        strategy wherein each
 *                                                        class object will have
 *                                                        seperate table.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
