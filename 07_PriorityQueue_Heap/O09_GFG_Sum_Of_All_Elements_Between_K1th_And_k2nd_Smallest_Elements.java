package PriorityQueue_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class O09_GFG_Sum_Of_All_Elements_Between_K1th_And_k2nd_Smallest_Elements {

    public static int brute(int[] nums, int k1, int k2){
        Arrays.sort(nums);

        int res = 0;
        for(int i=k1; i<k2-1; i++){
            res+=nums[i];
        }

        return res;
    }

    public static int optimal(int[] nums,int k1,int k2){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> a-b);

        for(int n :nums){
            maxHeap.add(n);

            if(maxHeap.size()>k2-1){
                maxHeap.poll();
            }
        }

        // maxHeap now contains the smallest (k2 - 1) elements
        // Remove (k2 - k1 - 1) smallest among them (those between k1-th and k2-th)
        int total = 0;
        int count = k2 - k1 - 1;
        while (count-- > 0) {
            total += maxHeap.poll();
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 3, k2 = 6;
//        Output : 26
//         3rd smallest element is 10. 6th smallest element
//         is 20. Sum of all element between k1 & k2 is
//         12 + 14 = 26

        System.out.println("Brute: "+brute(nums, k1, k2));
        System.out.println("Optimal: "+optimal(nums, k1, k2));
    }
}
