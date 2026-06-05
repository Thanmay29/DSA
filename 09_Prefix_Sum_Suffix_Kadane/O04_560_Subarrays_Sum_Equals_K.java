package Prefix_Sum_Suffix_Kadane;

import java.util.HashMap;

public class O04_560_Subarrays_Sum_Equals_K {
    public static int subarraySum(int[] nums, int k) {

        int count = 0, currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: prefix sum 0 has occurred once

        for (int num : nums) {
            currSum += num;

            // Check if there's a prefix sum such that currSum - prefixSum = k
            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }

            // Store current prefix sum in map
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k  = 2;
        System.out.println(subarraySum(nums,k));

        int[] nums1 = {1,2,3};
        int K = 3;
        System.out.println(subarraySum(nums1, K));
    }
}
