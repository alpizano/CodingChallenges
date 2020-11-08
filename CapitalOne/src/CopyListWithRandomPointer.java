import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // Key = val, Value = index
        Map<Integer,Integer> map = new HashMap<>();
        Node newHead;

        int index =0;
        for(Node cursor=head; cursor != null; cursor = cursor.next) {
            map.put(cursor.val, index++);
        }

        System.out.println(map);

        for(Node cursor=head; cursor != null; cursor = cursor.next) {
            //newHead = new Node(cursor.val);
            addToTail(head, cursor.val);
        }

        printList(head);

        return head;
    }

    public void addToTail(Node head, int val) {
        Node newNode = new Node(val);
        Node cursor = head;

        while(cursor != null) {
            if(cursor.next == null) {
                //newNode = cursor;
                cursor.next = newNode;
            }
        }
    }

    public void printList(Node head) {

        for(Node cursor=head; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            if(cursor.next != null) {
                System.out.print("->");
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.random = null;
        head.next.next = new Node(11);
        head.next.random =  head;
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.random = head.next.next.next.next.next;
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.random = head;
        head.next.next.next.random = head.next.next.next.next.next;


        CopyListWithRandomPointer test = new CopyListWithRandomPointer();
        test.copyRandomList(head);
        System.out.println(head.next.random.val);
    }
}
