import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Account account;
    private List<String> transactions;

    public Transaction() {
        account = new Account();
        transactions = new ArrayList<>();
    }

    void deposit(int money) {
        transactions.add(account.deposit(money));
    }

    void withdraw(int money) {
        transactions.add(account.deposit(money));
    }

    List<String> getTransaction() {
        return transactions;
    }
}
