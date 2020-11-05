public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode master = head;
        ListNode oddRef = head;
        ListNode evenRef = head.next;
        int count = 2;

        if(getSizeAndPrettyPrint(head) == 1 || getSizeAndPrettyPrint(head) == 2) {
            return head;
        }

        for (ListNode c1 = head, c2 = head.next; c2 != null; c2 = c2.next) {
            if( count % 2 != 0) {
                oddRef.next = c2;
                c1.next = c1.next.next;
                oddRef= c2;
                c1 = c2;
            }
            else {
                c1 = c1.next;
            }
            if(c2.next == null) {
                oddRef.next = evenRef;
                break;
            }
                count++;
        }
        return master;
    }

    public int getSizeAndPrettyPrint(ListNode head) {
        int count = 1;
        for (ListNode cursor = head; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            System.out.print("->");

            if (cursor.next == null) {
                System.out.print("NULL");
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        OddEvenLinkedList test = new OddEvenLinkedList();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        test.prettyPrint(list1);
        ListNode result = test.oddEvenList(list1);
        test.getSizeAndPrettyPrint(result);

    }

}
