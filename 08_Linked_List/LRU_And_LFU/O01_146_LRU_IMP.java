package Linked_List.LRU_And_LFU;

import java.util.HashMap;

/*
 * LeetCode 146 - LRU Cache
 *
 * HashMap + Doubly Linked List pattern:
 * - HashMap: O(1) access by key
 * - DLL: maintain MRU → head, LRU → tail
 */

public class O01_146_LRU_IMP {

    /* ---------------- DLL NODE ---------------- */
    private static class Node {
        int key;     // Node key
        int value;   // Node value
        Node prev;   // Pointer to previous node
        Node next;   // Pointer to next node

        Node(int key, int value) {
            this.key = key;       // Initialize key
            this.value = value;   // Initialize value
        }
    }

    /* ---------------- DATA STRUCTURES ---------------- */
    private final int capacity;       // Maximum capacity
    private int size;                 // Current size
    private final HashMap<Integer, Node> map;  // Key → Node map for O(1) access

    private final Node head;          // Dummy head (MRU)
    private final Node tail;          // Dummy tail (LRU)

    /* ---------------- CONSTRUCTOR ---------------- */
    public O01_146_LRU_IMP(int capacity) {
        this.capacity = capacity;     // Set max capacity
        this.size = 0;                // Initial size = 0
        this.map = new HashMap<>();   // Initialize map

        head = new Node(0, 0);        // Dummy head
        tail = new Node(0, 0);        // Dummy tail
        head.next = tail;             // Link head → tail
        tail.prev = head;             // Link tail → head
    }

    /* ---------------- GET OPERATION ---------------- */
    public int get(int key) {
        Node node = map.get(key);                 // Retrieve node from map

        if (node == null) return -1;             // Key not present → return -1

        moveToHead(node);                         // Key accessed → move to head (MRU)
        return node.value;                        // Return value
    }

    /* ---------------- PUT OPERATION ---------------- */
    public void put(int key, int value) {

        Node node = map.get(key);                 // Check if key exists

        if (node != null) {                       // Key exists
            node.value = value;                   // Update value
            moveToHead(node);                     // Move to MRU
        } else {                                  // Key does not exist
            Node newNode = new Node(key, value);  // Create new node
            map.put(key, newNode);                // Add to map
            addToHead(newNode);                    // Add node to DLL head (MRU)
            size++;                                // Increase cache size

            if (size > capacity) {                 // Capacity exceeded
                Node lru = removeTail();          // Remove LRU node (tail.prev)
                map.remove(lru.key);              // Remove from map
                size--;                            // Decrease size
            }
        }
    }

    /* ---------------- HELPER METHODS ---------------- */
    private void addToHead(Node node) {           // Add node to DLL head
        node.prev = head;                         // Point node.prev → head
        node.next = head.next;                    // Node.next → old head.next
        head.next.prev = node;                    // Old head.next.prev → node
        head.next = node;                         // Head.next → node
    }

    private void removeNode(Node node) {         // Remove node from DLL
        node.prev.next = node.next;              // prev.next → next
        node.next.prev = node.prev;              // next.prev → prev
    }

    private void moveToHead(Node node) {         // Move existing node to head
        removeNode(node);                        // Remove from current position
        addToHead(node);                         // Add to head (MRU)
    }

    private Node removeTail() {                  // Remove LRU node (tail.prev)
        Node lru = tail.prev;                    // Get last node
        removeNode(lru);                         // Remove from DLL
        return lru;                              // Return removed node
    }

    /* ---------------- MAIN METHOD (TEST) ---------------- */
    public static void main(String[] args) {

        O01_146_LRU_IMP cache = new O01_146_LRU_IMP(2); // Cache capacity = 2

        cache.put(1, 1);                        // Cache: {1=1}, MRU=1
        cache.put(2, 2);                        // Cache: {1=1, 2=2}, MRU=2
        System.out.println(cache.get(1));       // Access 1 → MRU=1 → output 1

        cache.put(3, 3);                        // Cache full → evict LRU(2) → add 3=3
        System.out.println(cache.get(2));       // 2 evicted → output -1
        System.out.println(cache.get(3));       // Access 3 → MRU=3 → output 3

        cache.put(4, 4);                        // Cache full → evict LRU(1) → add 4=4
        System.out.println(cache.get(1));       // 1 evicted → output -1
        System.out.println(cache.get(3));       // 3 remains → output 3
        System.out.println(cache.get(4));       // 4 remains → output 4
    }
}
