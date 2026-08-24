package PriorityQueue_Heap;

import java.util.PriorityQueue;

public class O19_Sort_K_Sorted_Array {

    public int[] sortK(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n]; // final sorted output
        int resultIndex = 0;       // pointer to fill result array

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min-heap holds candidates for "next smallest"

        // Step 1: push the first (k+1) elements into the heap
        // because the smallest element among the first k+1 positions
        // is guaranteed to be the correct first element of the sorted array
        for (int i = 0; i <= k && i < n; i++) {
            minHeap.offer(arr[i]);
        }

        // Step 2: for every remaining element in arr...
        for (int i = k + 1; i < n; i++) {
            result[resultIndex++] = minHeap.poll(); // pop current minimum -> it's correct for this output slot
            minHeap.offer(arr[i]);                   // push next incoming element to maintain window of size k+1
        }

        // Step 3: array exhausted, drain whatever remains in the heap in sorted order
        while (!minHeap.isEmpty()) {
            result[resultIndex++] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        O19_Sort_K_Sorted_Array sol = new O19_Sort_K_Sorted_Array();
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        int[] sorted = sol.sortK(arr, k);

        for (int num : sorted) {
            System.out.print(num + " "); // Output: 2 3 5 6 8 9 10
        }
    }
}