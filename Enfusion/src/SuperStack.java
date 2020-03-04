import java.util.Scanner;
import java.util.ArrayList;

public class SuperStack {

    enum Ops {
        PUSH,
        POP,
        INC
    }

    static void superStack(String[] operations) {
            // User enters 0 operations
            if (operations.length == 0) {
                System.out.println("Stack is EMPTY");
            }

            ArrayList<Integer> pseudoStack = new ArrayList<>();
            int lastIndex = 0;
            
            for (int i=0; i< operations.length; i++) {
                String operation = "";
                int val1 = 0;
                int val2 = 0;

                operation = operations[i].split(" ")[0];

                if (operations[i].split(" ").length > 1 && operations[i].split(" ").length <= 2) {
                    val1 = Integer.parseInt(operations[i].split(" ")[1]);
                    System.out.println("operation is: " + operation);
                    System.out.println("val is: " + val1);
                }
                if (operations[i].split(" ").length >= 3) {
                    val2 = Integer.parseInt(operations[i].split(" ")[2]);
                }

                switch(operation.toUpperCase()) {
                    case "PUSH":
                        pseudoStack.add(val1);
                        lastIndex++;
                        System.out.println("TOP of stack: " + pseudoStack.get(lastIndex-1));
                        break;
                    case "POP":
                        pseudoStack.remove(lastIndex-1);
                        lastIndex--;
                        if(pseudoStack.size() == 0) {
                            System.out.println("Stack is EMPTY");
                        }
                        else {
                            System.out.println("TOP of stack: " + pseudoStack.get(lastIndex - 1));
                        }
                        break;
//                    case "INC": pseudoStack();

                }
            }
    }

    public static void main (String[] args) {
        Scanner in = new Scanner (System.in);
       int operations_size = 0;

        // Read total operations to perform from terminal first
        operations_size = Integer.parseInt(in.nextLine().trim());

        String[] operations = new String[operations_size];
        for(int i= 0; i<operations_size; i++) {
            String operations_item;
            try {
                // Read individual operations from terminal
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
