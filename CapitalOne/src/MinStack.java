import java.util.ArrayDeque;

public class MinStack {
    Node head;
    // int min;
    ArrayDeque<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        head = null;
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        Node newNode = new Node(x);

        if(stack.isEmpty() || x < stack.peek()) {
            stack.push(x);
        }

        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void pop() {

        Node temp = head;
        head = head.next;
        temp.next = null;

        if(temp.val == stack.peek()) {
            stack.pop();
        }

    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack test = new MinStack();

    }

}
