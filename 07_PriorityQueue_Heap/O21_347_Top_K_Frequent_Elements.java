package PriorityQueue_Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class O21_347_Top_K_Frequent_Elements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // stores element -> frequency

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1); // count occurrences of each number
        }

        // max-heap: highest frequency at top; on tie, smaller value at top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> map.get(b).equals(map.get(a)) // do a and b have the SAME frequency?
                        ? a - b                       // if TIE: smaller value has higher priority
                        : map.get(b) - map.get(a)     // if NOT tied: higher frequency has higher priority
        );

        maxHeap.addAll(map.keySet()); // push every unique number into the heap

        int[] res = new int[k]; // holds the final top-k answer
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll(); // pop the most frequent remaining element, k times
        }

        return res;
    }

    public static void main(String[] args) {
        O21_347_Top_K_Frequent_Elements sol = new O21_347_Top_K_Frequent_Elements();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.print("Output: [");
        for (int num : sol.topKFrequent(nums1, k1)) System.out.print(num + " ");
        System.out.println("]"); // Expected: [1, 2]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.print("Output: [");
        for (int num : sol.topKFrequent(nums2, k2)) System.out.print(num + " ");
        System.out.println("]"); // Expected: [1]
    }
}