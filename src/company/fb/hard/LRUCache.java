package company.fb.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Design of a new data structure
 * Operation on linked list
 */
public class LRUCache {

    private ListNode<Integer> dummyHead;
    private ListNode<Integer> dummyTail;
    /**
     * It would be much faster using Map<Integer, ListNode>
     */
    private Map<Integer, Integer> keyToValueMap;
    private int capacity;

    public LRUCache(int capacity) {
        this.dummyHead = new ListNode<>(-1);
        this.dummyTail = new ListNode<>(-1);
        dummyHead.next = dummyTail;
        dummyTail.previous = dummyHead;

        this.keyToValueMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyToValueMap.containsKey(key)) {
            moveKeyToHeadOfTheList(key);
            return keyToValueMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (keyToValueMap.containsKey(key)) {
            moveKeyToHeadOfTheList(key);
            keyToValueMap.put(key, value);
        } else {
            if (keyToValueMap.keySet().size() < capacity) {
                insertKeyToHead(key);
                keyToValueMap.put(key, value);
            } else if (keyToValueMap.keySet().size() == capacity) {
                int lastKey = removeLastValueFromList();
                keyToValueMap.remove(lastKey);
                put(key, value);
            } else {
                throw new RuntimeException("Size exceeds capacity");
            }
        }
    }

    private int removeLastValueFromList() {
            int lastKey = dummyTail.previous.val;
            dummyTail.previous.previous.next = dummyTail;
            dummyTail.previous = dummyTail.previous.previous;
            return lastKey;
    }

    private void moveKeyToHeadOfTheList(int key) {
        ListNode<Integer> runningNode = dummyHead;
        /**
         * So Bad!
         */
        while(runningNode != null) {
            if (runningNode.val == key) {
                // remove current node
                runningNode.previous.next = runningNode.next;
                runningNode.next.previous = runningNode.previous;
                ListNode<Integer> node = new ListNode<>(key);
                node.next = dummyHead.next;
                dummyHead.next.previous = node;
                node.previous = dummyHead;
                dummyHead.next = node;

            }
            runningNode = runningNode.next;
        }
    }

    private void insertKeyToHead(int key) {
        ListNode<Integer> node = new ListNode<>(key);
        if (dummyHead.next != null) {
            node.next = dummyHead.next;
            dummyHead.next.previous = node;
        }
        dummyHead.next = node;
        node.previous = dummyHead;
    }

    @Override
    public String toString() {
        return keyToValueMap.toString() + " " + dummyHead.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        System.out.println(cache);
        cache.put(2, 2);
        System.out.println(cache);
        cache.put(3, 3);
        System.out.println(cache);
        cache.put(4, 4);
        System.out.println(cache);
        cache.put(3, 33);
        System.out.println(cache);
    }
}

class ListNode<T> {
    ListNode<T> previous;
    ListNode<T> next;
    T val;

    public ListNode(T val) {
        this.val = val;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (val != null) {
            sb.append(val);
        }
        if (next != null ) {
            sb.append("->").append(next.toString());
        }
        return sb.toString();
    }
}
