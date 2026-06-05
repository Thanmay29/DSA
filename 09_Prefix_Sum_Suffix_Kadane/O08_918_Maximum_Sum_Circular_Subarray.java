package Prefix_Sum_Suffix_Kadane;

import java.util.Arrays;

public class O08_918_Maximum_Sum_Circular_Subarray {
    public static int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], minSum = nums[0];
        int currMax = 0, currMin = 0;

        for(int n : nums){
            currMax = Math.max(n, currMax + n);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(n, currMin + n);
            minSum = Math.min(minSum, currMin);

            total += n;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, -2, 3, -2};
        int[] nums2 = {5, -3, 5};
        int[] nums3 = {-3, -2, -3};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Maximum Circular Subarray Sum: "
                + maxSubarraySumCircular(nums1)); // 3

        System.out.println();

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Maximum Circular Subarray Sum: "
                + maxSubarraySumCircular(nums2)); // 10

        System.out.println();

        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Maximum Circular Subarray Sum: "
                + maxSubarraySumCircular(nums3)); // -2
    }
}
