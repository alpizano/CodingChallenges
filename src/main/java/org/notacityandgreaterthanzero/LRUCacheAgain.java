import java.util.HashMap;
import java.util.Map;

public class LRUCacheAgain {
    Map<Integer, Node> map ;
    int capacity;
    Node head = new Node();
    Node tail = new Node();

    public LRUCacheAgain(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
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
        Node node = map.get(key);

        if(node != null) {
            node.val = value;
            remove(node);
            add(node);
        }
        else {
            if(map.size() == capacity) {
                remove(node);
                map.remove(key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
        }

    }

    public void add(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node() {

        }

        public Node(int key, int val) {
            this.key=key;
            this.val=val;
        }
    }
}
