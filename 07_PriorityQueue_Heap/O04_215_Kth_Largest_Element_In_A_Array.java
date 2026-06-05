package PriorityQueue_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class O04_215_Kth_Largest_Element_In_A_Array {

    // Brute force: Sort the array and return kth largest
    public int brute(int[] nums, int k) {
        Arrays.sort(nums); // Sort in ascending order
        return nums[nums.length - k]; // Kth largest is at index (length - k)
    }

    // Efficient approach using Min Heap
    public int findKthLargestElement(int[] nums, int k) {
        // Create a min heap (default PriorityQueue in Java)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate over each element
        for (int n : nums) {
            minHeap.add(n); // Add current element

            // Keep heap size at most k
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        O04_215_Kth_Largest_Element_In_A_Array obj = new O04_215_Kth_Largest_Element_In_A_Array();

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Brute: Kth largest element: " + obj.brute(nums1.clone(), k1));
        System.out.println("Heap : Kth largest element: " + obj.findKthLargestElement(nums1, k1));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Brute: Kth largest element: " + obj.brute(nums2.clone(), k2));
        System.out.println("Heap : Kth largest element: " + obj.findKthLargestElement(nums2, k2));
    }
}
