import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class LRUCache2 {
    Deque<Integer> queue;
    Map<Integer, Integer> map;
    int size;
    int capacity;

    public LRUCache2(int capacity) {
        queue = new ArrayDeque<>(capacity);
        map = new HashMap<>();
        size = 0;
        this.capacity=capacity;
    }

    public int get(int key) {
        // move to front of queue
        if(map.containsKey(key)) {
            queue.remove(key);
            queue.addFirst(key);
            return map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        // update
        if(map.containsKey(key)) {
            map.put(key, value);
            queue.remove(key);
            queue.addFirst(key);
            return;
        }

        queue.addFirst(key);
        map.put(key,value);
        size++;

        if(size > capacity) {
            int evictedKey =queue.removeLast();
            map.remove(evictedKey);
        }
    }

    public void print() {
        System.out.println("queue: " + queue);
        System.out.println("cache: " + map);
    }

    public static void main(String[] args) {
        LRUCache2 test = new LRUCache2(2);
        test.put(1,1);
        test.put(1,1);
        System.out.println("get(1): " + test.get(1));
        test.put(3,3);
        test.print();
        System.out.println("get(2): " + test.get(2));
        test.put(4,4);
        System.out.println("get(1): " + test.get(1));
        test.print();

    }
}
