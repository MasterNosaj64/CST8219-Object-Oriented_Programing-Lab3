/*
* Name: Jason Waid
* Student ID: 040912687
* Course & Section: CST8132 304
* Assignment: Lab 3
* 4186626850Date: Oct 3rd, 2018
*/
public class Client {

	// Variables Declared
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;

	public Client(String firstName, String lastName, long phoneNum, String email) {
		// Assigns incoming data to instance
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	// Get first & last name of Client
	public String getName() {
		// Returns First & Last Name with Space between
		return (firstName + " " + lastName);

	}

	// Get Phone Number of Client
	public long getPhoneNum() {
		return phoneNum;

	}

	// Get Email of Client
	public String getEmail() {
		return email;
	}

}
