public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if( head == null || head.next == null) {
            if(head != null && head.val == val) {
                head = null;
            }
            return head;
        }

        for(ListNode prev=head, curr=head.next; curr != null; curr=curr.next) {
            if(curr.val == val) {
                prev.next = curr.next;
                continue;
            }
            prev=prev.next;
        }

        if(head.val == val) {
            head = head.next;
        }

        return head;
    }

    public void print(ListNode head) {
        for(ListNode curr=head; curr != null; curr=curr.next) {
            System.out.print(curr.val + " ");
        }
    }

    public static void main(String[] args) {
        RemoveLinkedListElements test = new RemoveLinkedListElements();
        ListNode head = new ListNode(1,new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode (5, new ListNode(6, null)))))));
        test.removeElements(head, 6);
    }
}
