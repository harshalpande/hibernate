package connection.jpa.inheritance.strategy.single;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @Inheritance(strategy=InheritanceType.SINGLE_TABLE) This is not required to
 *                                                     mention, because it is by
 *                                                     understood by hibernate
 *                                                     as by Default. Other than
 *                                                     this you would have to
 *                                                     mention it.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name = "VEHICLE_TYPE", 
		discriminatorType = DiscriminatorType.STRING
)
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
