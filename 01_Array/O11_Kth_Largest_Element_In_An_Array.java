package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

//The Kth largest element in an array is the element that would be
// at position (n - k) if the array were sorted in ascending order.

//1st largest = Maximum element
//2nd largest = Second highest element
//3rd largest = Third highest element, and so on...

public class O11_Kth_Largest_Element_In_An_Array {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(sol(nums, k));
    }

    //normal and easy method but takes O(n log n)
    //not optimal but can be used
    public static int solution(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //Optimal use minheap (priority Queue) takes O(n log k)

    public static int sol(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min Heap
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }
        return minHeap.peek(); // Root of heap = Kth largest element
    }
}
