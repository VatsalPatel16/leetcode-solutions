package Medium;

import java.util.HashMap;
import java.util.Map;

// class ListNode for Doubly Linked List
class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

// Time Complexity: O(1) per operation (get(), put())
// Space Complexity: O(n) due to use of linked list and HashMap
class LRUCache {
    // variable capacity to store capacity of LRU cache
    private int capacity;
    // Map to store key and node
    private Map<Integer, ListNode> cacheMap;
    // Two pointer head and tail
    private ListNode head;
    private ListNode tail;

    // Initialization of all the variables
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        // Initializing head and tail with (-1, -1)
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        // Connecting head and tail
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // Method to get value from LRU cache
    public int get(int key) {
        // if cacheMap doesn't contain key then return -1
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        // otherwise get that node
        ListNode node = cacheMap.get(key);
        // remove from its position and add it to start of LL
        remove(node);
        add(node);
        // return value of that node
        return node.value;
    }

    // Method to put value in LRU cache
    public void put(int key, int value) {
        // if cacheMap contains given key then remove that node from LL
        if (cacheMap.containsKey(key)) {
            ListNode oldNode = cacheMap.get(key);
            remove(oldNode);
        }

        // Make new node with given key and value
        ListNode node = new ListNode(key, value);
        // put that key and node in the map
        cacheMap.put(key, node);
        // also add it to LL
        add(node);

        // Check if size of cacheMap is greater than capacity
        // if yes then remove node from the tail of the LL
        if (cacheMap.size() > capacity) {
            ListNode nodeToRemove = tail.prev;
            remove(nodeToRemove);
            cacheMap.remove(nodeToRemove.key);
        }
    }

    // Method to add node in LL
    private void add(ListNode node) {
        ListNode nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        node.prev = head;
        nextNode.prev = node;
    }

    // Method to remove node from LL
    private void remove(ListNode node) {
        ListNode nextNode = node.next;
        ListNode prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */