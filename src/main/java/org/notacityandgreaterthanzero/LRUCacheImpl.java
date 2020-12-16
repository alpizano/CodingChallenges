import java.util.HashMap;
import java.util.Map;

public class LRUCacheImpl {
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> map;
    int capacity;

    public LRUCacheImpl(int capacity) {
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);

        if(node != null) {
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // either adds ovverids
        Node node = map.get(key);
        if(node != null) {
            node.val = value;
            remove(node);
            add(node);
        }
        else {
            if(map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode = new Node(key,value);
            map.put(key,newNode);
            add(newNode);
        }



    }

    // add to head
    public void add(Node node) {
        // make node point to what head is pointing at
        node.next = head.next;
        // make node that head is pointing to prev point to node
        head.next.prev = node;
        // make head point to node
        head.next = node;
        // make node prev point to head
        node.prev = head;
    }

    // remove from tail
    public void remove(Node node) {
        // make next node prev point to node prev
       node.next.prev = node.prev;
       // make node prev point to node next
       node.prev.next = node.next;
    }

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public void print() {
        for(Node cursor = head; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val + " ");
        }
    }

    public static void main(String[] args) {
        LRUCacheImpl test = new LRUCacheImpl(10);
        test.add(new Node(1,1));
        test.add(new Node(2,2));
        test.add(new Node(3,3));
        test.add(new Node(4,4));
        test.print();
    }
}

