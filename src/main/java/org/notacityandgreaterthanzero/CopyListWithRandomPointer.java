import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node,Integer> keyNodeValueIndex = new LinkedHashMap<>();
        Map<Integer,Node> keyIndexValueRandomPointerNode = new LinkedHashMap<>();
        Map<Integer,Node> keyIndexValueReferenceToNode = new LinkedHashMap<>();
        Node newHead = null;

        int index =0;
        for(Node cursor=head; cursor != null; cursor = cursor.next) {
            keyNodeValueIndex.put(cursor, index);
            keyIndexValueRandomPointerNode.put(index, cursor.random == null ? null : cursor.random);
            newHead = addToTail(cursor, newHead, keyIndexValueReferenceToNode, index);
            index++;
        }

        index = 0;
        for(Node cursor=newHead; cursor != null; cursor = cursor.next) {
            cursor.random = keyIndexValueRandomPointerNode.get(index) == null ? null : keyIndexValueReferenceToNode.get(keyNodeValueIndex.get(keyIndexValueRandomPointerNode.get(index)));
            index++;
        }

        return newHead;
    }

    public Node addToTail(Node currNode, Node newHead, Map<Integer,Node> map, int index) {
        Node newNode = new Node(currNode.val);
        map.put(index, newNode);

        Node cursor = newHead;

        if(newHead == null) {
            newHead = newNode;
            return newHead;
        }

        while(cursor != null) {
            if(cursor.next == null) {
                cursor.next = newNode;
                break;
            }
            cursor = cursor.next;
        }

        return newHead;
    }


    public void printList(Node head) {

        for(Node cursor=head; cursor != null; cursor = cursor.next) {
            System.out.print("["+cursor+","+cursor.val+","+cursor.random+","+cursor.next+"]");
            if(cursor.next != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Node 7
        Node head = new Node(7);
        head.random = null;
        // node 13
        head.next = new Node(13);
        head.next.random =  head;
        // node 11
        head.next.next = new Node(11);
        // node 10
        head.next.next.next = new Node(10);
        head.next.next.next.random = head.next.next;
        // node 1
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.random = head;
        // node 11
        head.next.next.random = head.next.next.next.next;



        CopyListWithRandomPointer test = new CopyListWithRandomPointer();
        test.copyRandomList(head);
        System.out.println(head.next.random.val);
    }
}
