package PriorityQueue_Heap;

import java.util.PriorityQueue;

/**
 * This class maintains a stream of numbers and allows querying the kth largest element in real-time.
 * It uses a min-heap (PriorityQueue) to efficiently keep track of the k largest elements.
 */
public class O15_703_Kth_Largest_Elemen_In_A_Stream {

    public static void main(String[] args) {
        // Create object with k = 3 and initial array [4, 5, 8, 2]
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        // Add new elements and print kth largest after each addition
        kthLargest.add(3);  // Stream becomes [4, 5, 8, 2, 3] => 3rd largest is 4
        kthLargest.add(5);  // [4, 5, 8, 2, 3, 5] => 3rd largest is 5
        kthLargest.add(10); // [4, 5, 8, 2, 3, 5, 10] => 3rd largest is 5
        kthLargest.add(9);  // [4, 5, 8, 2, 3, 5, 10, 9] => 3rd largest is 8
        kthLargest.add(4);  // [4, 5, 8, 2, 3, 5, 10, 9, 4] => 3rd largest is 8

    }
}

/**
 * KthLargest class maintains the kth largest element in a stream.
 */
class KthLargest {
    private PriorityQueue<Integer> minHeap; // Min-heap to store k largest elements
    private int k;

    /**
     * Constructor to initialize KthLargest with given k and initial array.
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add all elements to the heap using the add method
        for (int num : nums) {
            add(num);
        }
    }

    /**
     * Adds a new value to the stream and returns the kth largest element.
     */
    public int add(int val) {
        // Add the new value to the heap
        minHeap.offer(val);

        // If the size of heap exceeds k, remove the smallest element
        // This ensures we are only keeping the k largest elements
        if (minHeap.size() > k) {
            minHeap.poll(); // Remove the smallest in heap
        }

        // The top of the heap is the kth largest element
        return minHeap.peek();
    }
}
