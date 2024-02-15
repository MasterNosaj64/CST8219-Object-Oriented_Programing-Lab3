import java.text.DecimalFormat;
import java.util.Scanner;

/*
* Name: Jason Waid
* Student ID: 040912687
* Course & Section: CST8132 304
* Assignment: Lab 3
* Date: Oct 3rd, 2018
*/
public class Bank {
	// Declare Variables
	private String bankName;
	private Account[] accounts;
	// Declare Scanner
	private Scanner input;

	public Bank() {
		// Declares Number of Accounts
		int numofAccts;

		// Initializing Scanner Object
		input = new Scanner(System.in);

		// Prompts user for name of Bank
		System.out.print("Please enter name of Bank: ");
		bankName = input.nextLine();
		System.out.println();

		// Prompts user for number of accounts
		System.out.print("Please enter number of Accounts: ");
		numofAccts = input.nextInt();
		System.out.println();

		// Initializes Size of Array
		accounts = new Account[numofAccts];

		// For loops prompt user for info on each account
		for (int i = 0; i < numofAccts; i++) {
			// Assigns accounts #ID if more than one account is used
			if (numofAccts > 1) {
				System.out.println("Account " + (i + 1));
			}

			// Prompt User for First Name
			System.out.print("Please enter First Name on Account: ");
			String firstName = input.next();
			System.out.println();

			// Prompt User for Last Name
			System.out.print("Please enter Last Name on Account: ");
			String lastName = input.next();
			System.out.println();

			// Prompt User for Phone Number
			System.out.print("Please enter Phone Number on Account: ");
			long phoneNum = input.nextLong();
			System.out.println();

			// Prompt User for Email
			System.out.print("Please enter E-mail Address on Account: ");
			String email = input.next();
			System.out.println();

			// Creates copy of Client class with provided info
			Client client = new Client(firstName, lastName, phoneNum, email);

			// Prompts user for opening Balance
			System.out.print("Please enter opening Balance: ");
			double balance = input.nextDouble();
			System.out.println();

			// Places account info into Array Index
			accounts[i] = new Account(client, balance);
		}
	}

	// Prints account details
	public void printAccounts() {
		DecimalFormat balance = new DecimalFormat("###,###,###.##");
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Account: " + (i + 1));
			System.out.println("Name:" + accounts[i].getName());
			System.out.println("Email:" + accounts[i].getClient().getEmail());
			System.out.println("Phone Number:" + accounts[i].getClient().getPhoneNum());
			System.out.println("Account Balance: " + balance.format(accounts[i].getBalance()));
		}
	}

	// Program executes from here
	public static void main(String[] args) {
		//Defines Decimal format
		DecimalFormat withdrawFormat = new DecimalFormat("###,###,###.##");
		// Creates instance of Bank Object
		Bank bank = new Bank();
		char controls;
		int power = 0;
		// Welcome user & Prompt User for info
		System.out.println();
		System.out.println("Welcome to My Bank ver 1.0");

		while (power == 0) {
			System.out.println("Controls:");
			System.out.println("p: Print Accounts");
			System.out.println("w: Withdraw");
			System.out.println("d: Deposit");
			System.out.println("q: Quit");
			System.out.println();
			// Read Command input
			controls = bank.input.next().charAt(0);

			switch (controls) {

			case 'p':
			case 'P':
				// calls print accounts
				bank.printAccounts();
				break;
			case 'w':
			case 'W':
				// Prompt user for desired account
				System.out.print("Please enter desired Account starting at 0: ");
				int withdrawAcct = bank.input.nextInt();
				System.out.println();
				// Prompts user for Withdrawal amount
				System.out.print("Please enter desired Withdraw: ");
				double acctWithdraw = bank.input.nextDouble();
				System.out.println();
				// While loop determines if withdrawal is larger than available balance
				while (acctWithdraw > bank.accounts[withdrawAcct].getBalance()) {
					System.out.println("Insufficient Funds! Balance is $" + withdrawFormat.format(bank.accounts[withdrawAcct].getBalance()) + ".");
					System.out.println();
					System.out.print("Please enter desired Withdraw: ");
					acctWithdraw = bank.input.nextDouble();
					System.out.println();
				}
				// If withdrawal is less than or equal to balance, apply withdrawal
				bank.accounts[withdrawAcct].deposit(acctWithdraw);
				break;
			case 'd':
			case 'D':
				// Prompt user for desired account
				System.out.print("Please enter desired Account starting at 0: ");
				int depositAcct = bank.input.nextInt();
				System.out.println();
				// Prompts user for Deposit amount
				System.out.print("Please enter desired Deposit: ");
				double acctDeposit = bank.input.nextDouble();
				System.out.println();
				bank.accounts[depositAcct].deposit(acctDeposit);
				break;
			case 'q':
			case 'Q':
				// quits program
				power++;
				System.out.println("Thank you for using My Bank");
				break;
			default:
				// prompts user to enter valid input
				System.out.print("Please enter a valid input: ");
				controls = bank.input.next().charAt(0);
				System.out.println();
			}
			System.out.println();
		}
	}
}
