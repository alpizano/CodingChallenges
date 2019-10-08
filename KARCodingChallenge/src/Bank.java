import java.util.ArrayList;

public class Bank {
	String name;
	ArrayList<Account> bankAccounts;

	public Bank() {
		name = "";
		bankAccounts = new ArrayList<>();
	}

	public Bank(String name) {
		this.name = name;
		bankAccounts = new ArrayList<>();
	}

	public void addAccount(String owner, int balance) {
		Account new_acct = new Account(owner, balance);
		bankAccounts.add(new_acct);
	}

	public void deposit(String accountName, int num) {
		for (Account a : bankAccounts) {
			if (a.owner.equals(accountName)) {
				a.balance = a.balance + num;
			}
		}
	}

	public void withdraw(String accountName, int num) {
		for (Account a : bankAccounts) {
			if (a.owner.equals(accountName)) {
				if (num >= 1000) {
					System.out.println("Withdrawal limit is 1000 dollars!");
				} else if (a.balance - num >= 0) {
					a.balance = a.balance - num;
				} else {
					System.out.println("You do not have sufficient balance to withdraw this amount!");
				}

			}
		}
	}

	public void transfer(String fromAccountName, String toAccountName, int num) {
		for (Account a : bankAccounts) {
			if (a.owner.equals(fromAccountName)) {
				if (a.balance - num >= 0) {
					a.balance = a.balance - num;
				}
			}
			if (a.owner.equals(toAccountName)) {
				a.balance = a.balance + num;
			}
		}
	}

	class Account {
		String owner;
		int balance;

		public Account() {
			owner = "";
			balance = 0;
		}

		public Account(String owner, int balance) {
			this.owner = owner;
			this.balance = balance;
		}
	}

	// inherits from Account superclass
	class Checking extends Account {
	}

	// inherits from Account superclass
	class Savings extends Account {
	}

	class Individual extends Checking {
	}

	class MoneyMarket extends Checking {
	}

	public static void main(String[] args) {

		// invoke a constructor deposit test
		Bank sample_bank = new Bank("Javier's Bank");
		sample_bank.addAccount("Javier's Account", 500);
		sample_bank.addAccount("Matt Massom's Account", 666);
		sample_bank.addAccount("Preston's Account", 9999);

		// testing deposit values
		for (Account a : sample_bank.bankAccounts) {
			System.out.println("The owner of this account is: " + a.owner + " and the balance is: " + a.balance);
		}

		System.out.println();

		// deposit using method
		sample_bank.deposit("Javier's Account", 500);

		// testing deposit values
		for (Account a : sample_bank.bankAccounts) {
			System.out.println("The owner of this account is: " + a.owner + " and the balance is: " + a.balance);
		}

		System.out.println();

		// invoke withdrawal
		sample_bank.withdraw("Javier's Account", 300);
		sample_bank.withdraw("Matt Massom's Account", 600);
		sample_bank.withdraw("Preston's Account", 10000);

		System.out.println();

		// testing withdrawal values
		for (Account a : sample_bank.bankAccounts) {
			System.out.println("The owner of this account is: " + a.owner + " and the balance is: " + a.balance);
		}

		System.out.println();

		// invoking transfer
		sample_bank.transfer("Matt Massom's Account", "Preston's Account", 50);

		// testing transfer values
		for (Account a : sample_bank.bankAccounts) {
			System.out.println("The owner of this account is: " + a.owner + " and the balance is: " + a.balance);
		}
	}
}