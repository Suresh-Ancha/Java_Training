package atmWithAccounts;

import java.util.Scanner; 

public class ATM {
	Scanner sc = new Scanner(System.in);
	Account account = new Account();
	int choice;

	public void createAccount()
	{
		System.out.println("Enter the Account Number");
		int accNum = sc.nextInt();
		account.setAccountnum(accNum);
		System.out.println("Enter the Pin Number ");
		int pinNum = sc.nextInt();
		account.setPin(pinNum);
		System.out.println("Enter the amount"); 
		double depositAmount = sc.nextDouble();
		account.deposit(depositAmount, accNum);
		 

	}
	public void login()
	{
		System.out.println("enter the account number");
		int accNum = sc.nextInt();
		System.out.println("enter pin number ");
		int pinNum = sc.nextInt();
		if(account.login(accNum, pinNum))
		{
			do
			{
				System.out.println("Welcome "+accNum);
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. View Transaction History");
				System.out.println("5. Exit");
				System.out.print("Choose an option: ");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Current balance: $" + account.checkBalance(accNum));
					break;
				case 2:
					System.out.print("Enter deposit amount: $");
					double depositAmount = sc.nextDouble();
					account.deposit(depositAmount,accNum);
					break;
				case 3:
					System.out.print("Enter withdrawal amount: $");
					double withdrawalAmount = sc.nextDouble();
					account.withdraw(withdrawalAmount,accNum);
					break;
				case 4:
					account.showTransactionHistory();
					break;
				case 5:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid option. Please try again.");
				}

				System.out.println();

			} while (choice != 5);

		}
	}
}
