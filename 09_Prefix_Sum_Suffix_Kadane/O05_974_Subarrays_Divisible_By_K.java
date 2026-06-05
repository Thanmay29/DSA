package Prefix_Sum_Suffix_Kadane;

import java.util.*;

public class O05_974_Subarrays_Divisible_By_K {

    public static int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // remainder 0 seen once

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            int remainder = prefixSum % k;
            if (remainder < 0) remainder += k; // handle negatives

            count += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;

        int[] nums2 = {5};
        int k2 = 9;

        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + subarraysDivByK(nums1, k1)); // 7

        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + subarraysDivByK(nums2, k2)); // 0
    }
}
