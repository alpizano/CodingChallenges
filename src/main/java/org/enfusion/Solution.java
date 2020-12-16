import java.security.SecureRandom;
import java.util.List;
import java.util.Scanner;

class TransactionRunnable implements Runnable {
    private static final SecureRandom RANDOM_GENERATOR = new SecureRandom();
    private final Transaction transaction;
    private final int transactionsCount;

    public TransactionRunnable(Transaction transaction, int transactionCount) {
        this.transaction = transaction;
        this.transactionsCount = transactionCount;
    }

    @Override
    public void run() {
        for(int i=0; i < this.transactionsCount; i++) {
            int transactionType = RANDOM_GENERATOR.nextInt() %2;
            int money = RANDOM_GENERATOR.nextInt(100) + 1;

            if (transactionType == 0) {
                this.transaction.deposit(money);
            }
            else {
                this.transaction.withdraw(money);
            }
        }
    }
}

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Account ACCOUNT = new Account();
    private static final Transaction TRANSACTION = new Transaction(ACCOUNT);

    public static void main(String[] args) throws InterruptedException{
        // first line of user input defines total # of threads
        int threadsCount = Integer.parseInt(SCANNER.nextLine());
        Thread[] threads = new Thread[threadsCount];

        int expectedTransactionCount = 0;
        // transactionsCount is the next line which is total # of transaction performed by each thread
        for(int i=0; i< threadsCount; i++) {
            int transactionsCount = Integer.parseInt(SCANNER.nextLine());
            expectedTransactionCount = expectedTransactionCount + transactionsCount;

            threads[i] = new Thread(new TransactionRunnable(TRANSACTION, transactionsCount));
        }

        for(int i=0; i<threadsCount; i++) {
            threads[i].start();
        }

        for(int i=0; i<threadsCount; i++) {
            threads[i].join();
        }

        List<String> transactions = TRANSACTION.getTransaction();

        if(transactions.size() != expectedTransactionCount) {
            System.out.println("Wrong answer");
        }

        else {
            boolean correct = true;
            for (String transaction : transactions) {
                if (transaction == null) {
                    correct = false;
                    break;
                }
            }

            if(!correct){
                System.out.println("Wrong answer");
            }
            else {
                int balance = ACCOUNT.getBalance();

                if (balance < 0) {
                    System.out.println("Wrong answer");
                }
                else {
                    for(String transaction: transactions){
                        System.out.println(transaction);
                    }
                    System.out.println("Balance $" + balance);
                }
            }
        }


    }
}
