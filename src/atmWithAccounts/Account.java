package atmWithAccounts;

public class Account {

	private int[] accountnum;
	private int accountcheck;
	private int pincheck;
	private int balcheck;
	private int[] pin;
	private double[] balance;
	private double[] transactions;
	private int transactionCount;
	int accnums;

	public Account() {
		balance = null;
		transactions = new double[100];
		transactionCount = 0;
		accountcheck = 0;
		pincheck = 0;
		balcheck = 0;
		accountnum = new int[100];
		pin = new int[100];
		balance = new double[100];
	}

	public boolean login(int accNum, int pinNum) {

		for (int i = 0; i <= accountcheck; i++) {
			if (accNum == accountnum[i]) {
				if (pinNum == pin[i]) {
					System.out.println("successfully login");
					return true;
				} else {
					System.out.println("Invalid account details");
				}
			}

		}
		return false;
	}

	public int getAccountNumber() {
		for (int i = 0; i < accountcheck; i++) {
			accnums = accountnum[i];
		}
		return accnums;
	}

	public void setAccountnum(int accountnum) {
		this.accountnum[accountcheck++] = accountnum;
	}

	public int getPin() {
		for (int i = 0; i < pincheck; i++) {
			return pin[i];
		}
		return 0;

	}

	public void setPin(int pinNum) {
		this.pin[pincheck++] = pinNum;
	}

	public double getBalance() {
		for (int i = 0; i < balcheck; i++) {
			return balance[i];
		}
		return 0;
	}

	public double checkBalance(int accNum) {
		for (int i = 0; i < accountcheck; i++) {
			accnums = accountnum[i];
			if (accnums == accNum) {
				return balance[i];
			}
		}
		return 0;
	}

	public void deposit(double amount, int accNum) {
		for (int i = 0; i < accountcheck; i++) {
			accnums = accountnum[i];
			if (accnums == accNum) {
				if (amount > 0) {
					balance[i] += amount;
					transactions[transactionCount++] = amount;
					System.out.println("Deposited successfully");
				} else {
					System.out.println("Invalid deposit amount.");
				}

			}

		}

	}

	public void withdraw(double amount, int accNum) {
		for (int i = 0; i < accountcheck; i++) {
			accnums = accountnum[i];
			if (accnums == accNum) {
				if (amount > balance[i]) {
					System.out.println("Insufficient balance.");
				} else if (amount <= 0) {
					System.out.println("Invalid withdrawal amount.");
				} else {
					balance[i] -= amount;
					transactions[transactionCount++] = -amount;
				}
			}
		}
	}

	public void showTransactionHistory() {
		System.out.println("Transaction History:");
		for (int i = 0; i < transactionCount; i++) {
			if (transactions[i] > 0) {
				System.out.println("Deposit: $" + transactions[i]);
			} else {
				System.out.println("Withdraw: $" + (-transactions[i]));
			}
		}
	}

}
