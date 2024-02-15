import java.util.Random;

/*
* Name: Jason Waid
* Student ID: 040912687
* Course & Section: CST8132 304
* Assignment: Lab 3
* Date: Oct 3rd, 2018
*/

public class Account {
	// Random Constructor

	// Holds Account Number
	private long accountNum;
	// Client Identifier
	private Client client;
	// Starting account balance
	private double balance;

	public Account(Client client, double balance) {
		//Assigns incoming data to instance
		this.client = client;
		this.balance = balance;

		Random random = new Random();
		// Assigns Random Account Number
		accountNum = random.nextLong();

	}

	// Prompt user for deposit
	public double deposit(double amt) {
		// take deposit add to balance
		balance += amt;
		return balance;
	}

	// Prompt User for Withdrawal
	public boolean withdraw(double amt) {
		// if withdraw more than balance return false
		if (amt > balance) {
			return false;
		}

		// if withdraw less than or equal to balance return true
		else {

			balance -= amt;
			return true;
		}
	}

	// Gets Account Number
	public long getAccountNum() {

		return accountNum;
	}

	// Method gets name from Client Class
	public Client getClient() {

		return client;

	}

	// Get current balance
	public double getBalance() {
		return balance;

	}

	// Get name of client
	public String getName() {
		return client.getName();
	}
}
