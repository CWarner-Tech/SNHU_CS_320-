package main;

public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	// Initialize constructor
	public Contact(String contactId, String firstName, String lastName, String Number, String Address) {
		// Validate input parameters
		if (contactId == null || contactId.length() >10) {
			throw new IllegalArgumentException("Invalid contactId.");
		}
		if (firstName == null || firstName.length() >10) {
			throw new IllegalArgumentException("Invalid first name.");	
		}
		if (lastName == null || lastName.length() >10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		if (Number == null || !Number.matches("\\d{10}")){
			throw new IllegalArgumentException("Invalid Number.");
		}
		if (Address == null || Address.length() >30) {
			throw new IllegalArgumentException("Invalid Address.");
		}
		
		//Initialize fields
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Number = Number;
		this.Address = Address;
	}

	//getters and setters with validation
	public String getFirstName() {
		return firstName;
	}
	//Setter for firstName with validation
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() >10) {
			throw new IllegalArgumentException("Invalid first name.");
			}
		this.firstName = firstName;
	}
	
	//Getter for lastName
	public String getLastName() {
		return lastName;
	}
	// Setter for lastName with validation
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() >10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		
		this.lastName = lastName;
	}
	//Getter for Number
	public String getNumber() {
		return Number;
	}
	
	//Setter for Number with validation
	public void setNumber(String Number) {
		if (Number == null || !Number.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Number.");
		}
		
		this.Number = Number;
	}
	
	// Getter for address
	public String getAddress() {
		return Address;
	}
	
	// Setter for Address with validation
	public void setAddress(String Address) {
		if (Address == null|| Address.length() >30) {
			throw new IllegalArgumentException("Invalid Address.");
		}
		this.Address = Address;
	}

	// Getter for contactId
	public String getContactId() {
		return contactId;
	}
	
}
