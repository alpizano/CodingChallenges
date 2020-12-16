public class Account {
    private int balance;

    public Account() {
        balance = 0;
    }

    String deposit(int money) {
        return "Despositing $" + money;
    }

    String withdraw(int money) {
        int newBalance = money - balance;

        if (newBalance > 0) {
            balance = balance - money;
            return "Withdrawing $" + money;

        } else {
            return "Withdrawing $" + money + " (Insufficient Balance)";
        }
    }

    int getBalance() {
        return balance;
    }
}
