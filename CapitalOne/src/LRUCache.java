import java.lang.reflect.Array;
import java.util.*;

public class LRUCache {
    // Queue for queue API, Deque for stack API
    ArrayDeque<Integer> list;
    Map<Integer, Integer> cache = new HashMap<>();
    int capacity;
    int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayDeque<>(capacity);
    }

    public int get(int key) {
        // whenever interact, move item to front of list

        // LIST: if exists, and interfact, swap to front (remove & add to head)
        // O(1) lookup
        if(cache.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);
            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        // if key exists, update value ( we don't care about capacity)
        if(cache.containsKey(key)) {
            // Update in hashmap/cache
            cache.put(key,value);
            list.remove(key);
            list.addFirst(key);
            return;
        }


       // if size != capacity, add new key to front of doubly-linked list
        if(size != capacity) {
            cache.put(key,value);
            list.addFirst(key);
            size++;
        }
        // else size == capacity, remove last used item (LRU contract)
        else {
            cache.remove(list.getLast());
            list.removeLast();
            list.addFirst(key);
            cache.put(key,value);
        }
    }

    public void print() {
        // should be in-sync at all times
        System.out.println("cache" + cache);
        for(Integer val : list) {
            System.out.print("[key: " + val + "]");
        }
        System.out.println();
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        lruCache.print();
        lruCache.get(1);    // return 1
        lruCache.print();
        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lruCache.print();
        lruCache.get(2);    // returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lruCache.get(1);    // return -1 (not found)
        lruCache.get(3);    // return 3
        lruCache.get(4);    // return 4


    }
}

class LRUNode {
    int key;
    int value;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LRUNode lruNode = (LRUNode) o;
        return key == lruNode.key ;
              //  && value == lruNode.value;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(key, value);
        return Objects.hash(key);
    }
}
