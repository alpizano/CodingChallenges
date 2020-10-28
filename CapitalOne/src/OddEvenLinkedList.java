public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        return null;
    }

    public void prettyPrint(ListNode head) {
        for (ListNode cursor = head; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            System.out.print("->");

            if (cursor.next == null) {
                System.out.print("NULL");
            }
        }
    }

    public static void main(String[] args) {
        OddEvenLinkedList test = new OddEvenLinkedList();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        test.prettyPrint(list1);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}