package PriorityQueue_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class O05_GFG_Kth_Smallest_Element_In_A_Array {

    public static int brute(int[] nums, int k){
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums[k-1];
    }

//    time complexity: O(n log k)
    public static int optimal(int[] nums, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : nums){
            maxHeap.add(n);

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 5, 6, 1};
        int k = 3;

        int res = brute(nums, k);
        System.out.println("brute: "+res);

        int op = optimal(nums, k);
        System.out.println("optimal: "+op);
    }
}
