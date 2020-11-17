import com.sun.scenario.effect.Merge;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 == null && l2 == null) {
            return null;
        }
        else if(l1 == null && l2 != null) {
            return l2;
        }
        else if(l2 == null && l1 != null) {
            return l1;
        }

        // Node c2 = l2;
        // Node c1 = l1;
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
                prev = prev.next;

                if(l1 == null) {
                    prev.next = l2;
                }
            }
            else if(l2.val <= l1.val) {
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;

                if(l2 == null) {
                    prev.next = l1;
                }
            }
        }


        return preHead.next;

    }

    public void print(ListNode l1) {
        for(ListNode cursor = l1; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode (5)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode (3, new ListNode(6))));
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode (4)));
//        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode (4)));

        MergeTwoSortedLists test = new MergeTwoSortedLists();
        test.print(test.mergeTwoLists(l1, l2));
    }
}
