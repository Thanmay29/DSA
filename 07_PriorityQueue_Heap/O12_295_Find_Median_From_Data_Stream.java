package PriorityQueue_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class O12_295_Find_Median_From_Data_Stream {

    // Max Heap to store the smaller half
    private PriorityQueue<Integer> low;

    // Min Heap to store the larger half
    private PriorityQueue<Integer> high;

    public O12_295_Find_Median_From_Data_Stream() {
        low = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        high = new PriorityQueue<>(); // Min-heap
    }

    // Adds a number into the data structure
    public void addNum(int num) {
        // Step 1: Add to max-heap
        low.offer(num);

        // Step 2: Balance: move max from low to high
        high.offer(low.poll());

        // Step 3: Re-balance if needed to maintain size property
        if (low.size() < high.size()) {
            low.offer(high.poll());
        }
    }

    // Returns the median of all numbers added so far
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        O12_295_Find_Median_From_Data_Stream mf = new O12_295_Find_Median_From_Data_Stream();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // Output: 1.5

        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // Output: 2.0
    }
}
