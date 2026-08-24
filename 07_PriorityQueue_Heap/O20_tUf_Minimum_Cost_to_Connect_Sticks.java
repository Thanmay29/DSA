package PriorityQueue_Heap;

import java.util.PriorityQueue;

public class O20_tUf_Minimum_Cost_to_Connect_Sticks {

    public int connectSticks(int[] sticks) {
        // min-heap: always gives us the smallest stick at the top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stick : sticks) {
            minHeap.offer(stick); // add all sticks into the heap initially
        }

        int totalCost = 0; // accumulates total cost of all merges

        // keep merging until only one stick remains
        while (minHeap.size() > 1) {
            int first = minHeap.poll();  // smallest stick
            int second = minHeap.poll(); // second smallest stick

            int cost = first + second;   // cost of merging these two
            totalCost += cost;           // add to running total

            minHeap.offer(cost);         // push merged stick back into the pool
        }

        return totalCost; // final answer: sum of all merge costs
    }

    public static void main(String[] args) {
        O20_tUf_Minimum_Cost_to_Connect_Sticks sol = new O20_tUf_Minimum_Cost_to_Connect_Sticks();
        System.out.println(sol.connectSticks(new int[]{2, 4, 3}));       // 14
        System.out.println(sol.connectSticks(new int[]{1, 8, 3, 5}));    // 30
        System.out.println(sol.connectSticks(new int[]{5}));             // 0 (only one stick, no merge needed)
    }
}