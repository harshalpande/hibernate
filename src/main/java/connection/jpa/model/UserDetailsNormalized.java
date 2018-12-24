package connection.jpa.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "User_Details")
public class UserDetailsNormalized {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "User_Name")
	private String userName;

	/**
	 * @ElementCollection - Normalized Table creation
	 * @JoinTable = used to change the name to user desire with name-Attribute
	 *            joinColumns = @JoinColumn : used to change the foreign key name to
	 *            User Desired name
	 * @CollectionId : First Annotation to come from org.hibernate package To add
	 *               primary key to the normalized table (with Autogenerator field),
	 *               GenericGenerator, strategy - jboss online documentation
	 *               different strategies for GenericGenerator. You Change strategy
	 *               and you will get different combinations of table and their
	 *               generated value.
	 *               
	 * FetchType.Eager/Lazy - Hibernate Proxy concept wherein main Class data is fetched and subsequent class
	 */

	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "harshal-idgen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "harshal-idgen", type = @Type(type = "long"))
	private Collection<Address> listOfAddress = new ArrayList<Address>();

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

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
}
