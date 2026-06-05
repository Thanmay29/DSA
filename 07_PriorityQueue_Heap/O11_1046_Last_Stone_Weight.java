package PriorityQueue_Heap;

import java.util.PriorityQueue;

public class O11_1046_Last_Stone_Weight {

    // Function to return the last remaining stone's weight
    public static int lastStone(int[] stones) {
        // Max-heap: using custom comparator to simulate max behavior
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Step 1: Add all stones to the max-heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Step 2: Smash stones until at most one remains
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // heaviest
            int stone2 = maxHeap.poll(); // second heaviest

            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2); // push remaining stone
            }
            // If equal, both stones are destroyed (nothing to add)
        }

        // Step 3: Return result
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {1};

        System.out.println("Last stone weight (Test 1): " + lastStone(stones1)); // Output: 1
        System.out.println("Last stone weight (Test 2): " + lastStone(stones2)); // Output: 1
    }
}
