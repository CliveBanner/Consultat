package consultat.root.dummybackend;

import java.io.Serializable;

/**
 * A entity object, like in any other Java application. In a typical real world
 * application this could for example be a JPA entity.
 */
public class Customer implements Serializable, Cloneable {

	private Long id;

	private String business = "";
	private String name = "";
	private String street = "";
	private String plz = "";
	private String town = "";

	private CustomerStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the value of status
	 *
	 * @return the value of status
	 */
	public CustomerStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of status
	 *
	 * @param status
	 *            new value of status
	 */
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	
	/**
	 * @return the business
	 */
	public String getBusiness() {
		return business;
	}

	/**
	 * @param business the business to set
	 */
	public void setBusiness(String business) {
		this.business = business;
	}

	/**
	 * Get the value of firstName
	 *
	 * @return the value of firstName
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of firstName
	 *
	 * @param name
	 *            new value of firstName
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the value of street
	 *
	 * @return the value of street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Set the value of street
	 *
	 * @param street
	 *            new value of street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Get the value of plz
	 *
	 * @return the value of plz
	 */
	public String getPlz() {
		return plz;
	}

	/**
	 * Set the value of plz
	 *
	 * @param street
	 *            new value of plz
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}

	/**
	 * Get the value of town
	 *
	 * @return the value of town
	 */
	public String getTown() {
		return town;
	}
	
	/**
	 * Set the value of town
	 *
	 * @param street
	 *            new value of town
	 */
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getAdress() {
		return street+" "+plz+" "+town;
	}

	public boolean isPersisted() {
		return id != null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.id == null) {
			return false;
		}

		if (obj instanceof Customer && obj.getClass().equals(getClass())) {
			return this.id.equals(((Customer) obj).id);
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 43 * hash + (id == null ? 0 : id.hashCode());
		return hash;
	}

	@Override
	public Customer clone() throws CloneNotSupportedException {
		return (Customer) super.clone();
	}

	@Override
	public String toString() {
		return business+""+name+""+street+""+plz+""+town;
	}
}
