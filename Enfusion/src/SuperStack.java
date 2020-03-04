import java.util.Scanner;

public class SuperStack {
    static void superStack(String[] operations) {
        int[]
            if operations.length == 0
    }

    public static void main (String[] args) {
        Scanner in = new Scanner (System.in);
        int operations_size = 0;
        operations_size = Integer.parseInt(in.nextLine().trim());

        String[] operations = new String[operations_size];
        for(int i= 0; i<operations_size; i++) {
            String operations_item;
            try {
                operations_item = in.nextLine();
            }
            catch(Exception e) {
                operations_item = null;
            }
            operations[i] = operations_item;
        }
        superStack(operations);
    }
}
