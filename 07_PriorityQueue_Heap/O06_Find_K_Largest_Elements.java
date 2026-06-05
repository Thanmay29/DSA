package PriorityQueue_Heap;


//Input:  [1, 23, 12, 9, 30, 2, 50], k = 3
//Output: [50, 30, 23]
//
//Input:  [11, 5, 12, 9, 44, 17, 2], k = 2
//Output: [44, 17]

import java.util.PriorityQueue;

public class O06_Find_K_Largest_Elements {

    public static void brute(int[] nums, int k){
        int n = nums.length;

        for(int i=0;i<n-1; i++){
            for(int j=0;j<n-i-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        System.out.print("Brute: ");
        for(int i=n-k; i<n; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void optimal(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int n : nums){
            minHeap.add(n);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        System.out.print("Optimal: ");
        while(!minHeap.isEmpty()){
            System.out.print(minHeap.poll()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        brute(nums, k);
        optimal(nums, k);
    }
}
