package retail;

import java.io.Serializable;

// TODO: Must include appropriate imports for ExternalizableLite


/**
 * 
 * @author Education
 *
 */
// TODO: Must implement ExternalizableLite
public class Customer implements Serializable, Entity <Long> {

	private Long id;
	private String name; 
	private Address address; 
	
	private static final long serialVersionUID = 1L;

	// TODO: Must include a no=argument constructor
	public Customer() {	}
		
	public Customer(Long id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Customer:\n");
		sb.append("\tID:").append(id).append("\n");
		sb.append("\tName:").append(name).append("\n");
		if (address != null)
			sb.append(address.toString()).append("\n");
		else
			sb.append("Address: null").append("\n");
		return sb.toString();
	}


    // TODO: Must include a readExternal methods/
	// which reads fields in the same order as written
	

	// TODO: Must include a writeExternal method
	// which writes fields in the same order read
	

}
