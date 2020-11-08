public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {


        return null;
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
