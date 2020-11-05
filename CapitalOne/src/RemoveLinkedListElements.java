public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        for(ListNode prev=head, curr=head.next; curr != null; curr=curr.next) {
            if(curr.val == val) {
                prev.next = curr.next;
                prev = curr;
                break;
            }
            prev=prev.next;
        }

        print(head);

        return head;

    }

    public void print(ListNode head) {
        for(ListNode curr=head; curr != null; curr=curr.next) {
            System.out.print(curr.val + " ");
        }
    }

    public static void main(String[] args) {

    }
}
