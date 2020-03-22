public class Account {
    int balance;

    public Account() {
        balance = 0;
    }

    public String deposit(int money) {
        return "Despositing " + money;
    }

    public String withdraw(int money) {
        int newBalance = money - balance;

        if(newBalance > 0) {
            balance = balance - money;
            return "Withdrawing " + money;

        }
        else {
            return "Withdrawing " + money + " (Insufficient Balance)";
        }
    }


    public int getBalance() {
        return balance;
    }
}
