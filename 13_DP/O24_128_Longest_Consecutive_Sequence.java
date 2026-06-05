package DP;

import java.util.HashSet;

public class O24_128_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 20, 1, 3, 2};
        System.out.println(sol(nums));
    }

    public static int sol(int[] nums){
        if (nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);  // Store unique numbers

        int maxCount = 0;
// HashSet lookups are O(1) on average.
//We only start counting when we find the first number of a sequence, avoiding redundant checks.
//Total complexity: O(n).

        for (int num : numSet) {
            // Start a new sequence if `num-1` is not present
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
