package DP;

import java.util.*;

public class O13_368_Longest_Divisible_SubSet {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};

        //Tabulation
        System.out.println(tab(nums));
    }


    //Tabulation
    public static List<Integer> tab(int[] nums){

        Arrays.sort(nums); // Step 1: Sort the array

        int n = nums.length;
        int[] dp = new int[n]; // Stores the size of the largest subset ending at i
        int[] prev = new int[n]; // Stores the previous index in the subset

        Arrays.fill(dp, 1);  // Every element itself is a valid subset
        Arrays.fill(prev, -1);

        int maxSize = 1, maxIndex = 0; // Track the largest subset size and where it ends

        // Step 2: Build DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) { // Check divisibility
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j; // Store the previous index in the subset
                    }
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Step 3: Reconstruct the largest subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(result); // Reverse to maintain increasing order
        return result;
    }
}
