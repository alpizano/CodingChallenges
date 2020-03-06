import java.util.Scanner;
import java.util.ArrayList;

// This is my superstack code
public class SuperStack {

    enum Ops {
        PUSH,
        POP,
        INC
    }

    static void superStack(String[] operations) {
            // User enters 0 operations
            if (operations.length == 0) {
                System.out.println("You entered 0 operations so there's nothing to do");
            }

            ArrayList<Integer> pseudoStack = new ArrayList<>();
            int head = 0;
            int tail = 0;

            for (int k=0; k < operations.length; k++) {
                String operation = "";
                int v = 0;
                int i = 0;

                operation = operations[k].split(" ")[0];

                if (operations[k].split(" ").length > 1 && operations[k].split(" ").length <= 2) {
                    v = Integer.parseInt(operations[k].split(" ")[1]);
                    System.out.println("operation is: " + operation);
                    System.out.println("val is: " + v);
                }
                if (operations[k].split(" ").length >= 3) {
                    i = Integer.parseInt(operations[k].split(" ")[2]);
                }

                switch(operation.toUpperCase()) {
                    case "PUSH":
                        pseudoStack.add(v);
                        tail++;
                        // print top of stack
                        System.out.println(pseudoStack.get(tail-1));
                        break;
                    case "POP":
                        // stack is empty
                        if(pseudoStack.size() == 0) {
                            System.out.println("EMPTY");
                        }
                        else {
                            pseudoStack.remove(tail-1);
                            tail--;
                            // print top of stack
                            System.out.println(pseudoStack.get(tail - 1));
                        }
                        break;
                    case "INC":
                        while(head < i) {
                            pseudoStack.set(head, v);
                            head++;
                        }
                        


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
