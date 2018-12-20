package connection.jpa.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
@Table(name = "User_Details")
public class UserDetails {

	/**
	 * @AttributeOverrides cant be performed if we have a remote scenario wherein
	 *                     Primary Key Annotated by @Id is a value class/object in
	 *                     that scenario, we have to MANDATORILY use @EmbeddedId as
	 *                     annotation to perform @AttributeOverride for inside
	 *                     object/class fields. But remember since it will behave as
	 *                     composite key in tables, hence we can't have more than
	 *                     once instance/presence of the class/object
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto Increment Column in a Table - Does not need to set value
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Temporal(TemporalType.DATE)
	@Column(name = "JOINING_DATE")
	private Date joiningDate;

	// @Basic() - to be used if we need to use its parameter otherwise using it
	// alone doesn't make any effect
	// LOB - LargeObject

	@Lob
	@Column(name = "DESCRIPTION")
	private String description;

	/**
	 * to define that this is embedded here in USER_DETAILS class. This annotation
	 * is not required
	 */
	/**
	 * @AttributeOverride(s) is used when we have same model class as Value
	 * Object/Class used more than once just like Address and we can have Office and
	 * Home address as 2 different types. So the DB table can't contain STREET as
	 * name for both the Address it should have Street_Address and Office_Address as
	 * seperate column in the table, hence to keep that bifurcation/identication in
	 * table columns we use @AttributeOverrides (for performing
	 * multiple @AttributeOverride)
	 */

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "building", column = @Column(name = "HOME_BUILDING")),
			@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE")), })
	private Address homeAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "building", column = @Column(name = "OFFICE_BUILDING")),
			@AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
			@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE")), })
	private Address officeAddress;

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
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

}
