package Linked_List.LRU_And_LFU;

import java.util.HashMap;

/*
 * LeetCode 460 - LFU Cache (Hard)
 *
 * Design a data structure that supports:
 * - get(key) : return value if present, else -1
 * - put(key, value) : add or update key-value
 *
 * Eviction policy:
 * - Remove least frequently used key when full
 * - If frequency ties, remove least recently used key
 *
 * All operations should be O(1)
 *
 * Pattern Used:
 * - HashMap for O(1) key access
 * - HashMap of frequency → Doubly Linked List (DLL)
 * - Each DLL maintains LRU order within same frequency
 * - minFreq tracker for fast eviction
 */

public class O02_460_LFU_IMP_Hard {

    /* ---------------- NODE DEFINITION ---------------- */
    private static class Node {
        int key;      // Key of the node
        int value;    // Value of the node
        int freq;     // Frequency count of accesses
        Node prev;    // Pointer to previous node in DLL
        Node next;    // Pointer to next node in DLL

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // New nodes start with frequency 1
        }
    }

    /* ---------------- DOUBLY LINKED LIST ---------------- */
    /*
     * Each frequency has its own DLL.
     * MRU nodes are near head, LRU nodes near tail
     */
    private static class DoublyLinkedList {
        Node head;   // Dummy head
        Node tail;   // Dummy tail
        int size;    // Number of nodes in DLL

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {                     // Add node at head (MRU)
            node.next = head.next;                    // Connect node to head's next
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;                                    // Increase DLL size
        }

        void removeNode(Node node) {                  // Remove node from DLL
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;                                    // Decrease DLL size
        }

        Node removeTail() {                           // Remove LRU node (before tail)
            if (size == 0) return null;
            Node lru = tail.prev;
            removeNode(lru);
            return lru;
        }
    }

    /* ---------------- LFU CACHE STRUCTURES ---------------- */
    private final int capacity;                         // Maximum capacity
    private int size;                                   // Current cache size
    private int minFreq;                                // Minimum frequency in cache

    private final HashMap<Integer, Node> nodeMap;      // key -> Node
    private final HashMap<Integer, DoublyLinkedList> freqMap; // freq -> DLL of nodes

    /* ---------------- CONSTRUCTOR ---------------- */
    public O02_460_LFU_IMP_Hard(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    /* ---------------- GET OPERATION ---------------- */
    public int get(int key) {
        Node node = nodeMap.get(key);                   // Get node from map
        if (node == null) return -1;                    // Key not found → return -1
        updateFrequency(node);                          // Increase frequency and move node
        return node.value;                              // Return value
    }

    /* ---------------- PUT OPERATION ---------------- */
    public void put(int key, int value) {

        if (capacity == 0) return;                      // Cache cannot store anything → exit

        if (nodeMap.containsKey(key)) {                // Key exists
            Node node = nodeMap.get(key);
            node.value = value;                         // Update value
            updateFrequency(node);                      // Increase frequency
            return;
        }

        // Key does not exist → insert new node
        if (size == capacity) {                         // Cache full → evict LFU
            DoublyLinkedList minFreqList = freqMap.get(minFreq); // Get DLL with minFreq
            Node evictNode = minFreqList.removeTail();  // Remove LRU in that frequency
            nodeMap.remove(evictNode.key);             // Remove from key map
            size--;                                     // Decrease size
        }

        Node newNode = new Node(key, value);           // Create new node
        nodeMap.put(key, newNode);                     // Add to key map
        freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()) // Ensure freq=1 DLL exists
                .addNode(newNode);                     // Add new node to freq=1 DLL
        minFreq = 1;                                   // Reset minFreq to 1
        size++;                                        // Increase size
    }

    /* ---------------- UPDATE FREQUENCY ---------------- */
    private void updateFrequency(Node node) {
        int currFreq = node.freq;
        DoublyLinkedList currList = freqMap.get(currFreq); // Current frequency DLL
        currList.removeNode(node);                        // Remove node from current DLL

        if (currFreq == minFreq && currList.size == 0) {  // If node was only node at minFreq
            minFreq++;                                     // Increase minFreq
        }

        node.freq++;                                      // Increase node frequency
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()) // Ensure new freq DLL exists
                .addNode(node);                            // Add node to new DLL
    }

    /* ---------------- MAIN METHOD (TEST) ---------------- */
    public static void main(String[] args) {

        O02_460_LFU_IMP_Hard cache = new O02_460_LFU_IMP_Hard(2);

        cache.put(1, 1);                        // Cache: {1=1}, minFreq=1
        cache.put(2, 2);                        // Cache: {1=1, 2=2}, minFreq=1
        System.out.println(cache.get(1));       // Access 1 → freq=2 → output 1

        cache.put(3, 3);                        // Evict key 2 (freq=1, LRU) → add 3=3
        System.out.println(cache.get(2));       // Key 2 evicted → output -1
        System.out.println(cache.get(3));       // Access 3 → freq=2 → output 3

        cache.put(4, 4);                        // Evict key 1 (freq=2) → tie-break LRU → add 4=4
        System.out.println(cache.get(1));       // Key 1 evicted → output -1
        System.out.println(cache.get(3));       // Access 3 → freq=3 → output 3
        System.out.println(cache.get(4));       // Access 4 → freq=2 → output 4
    }
}
