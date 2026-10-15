package Binary_Search.BS_On_Answer;

import java.util.Arrays;

public class O010_Aggressive_Cows_classic {

    public static int aggressiveCows(int[] nums, int k) {
        // Distances only make sense between neighbours in order, so sort first
        Arrays.sort(nums);

        // Search range for the answer, which is a DISTANCE:
        // left  = 1 (smallest useful gap, stalls are at distinct positions)
        // right = distance between the two end stalls (cows can't be farther apart than this)
        int left = 1, right = nums[nums.length - 1] - nums[0];

        // Binary search for the LARGEST minimum distance that works (stops when left == right)
        while (left < right) {
            // mid = the minimum distance we are testing: "can every pair of cows be >= mid apart?"
            // Round up so that 'left = mid' always makes progress (no infinite loop)
            int mid = left + (right - left + 1) / 2;

            if (canPlace(nums, mid, k)) {
                // All k cows fit with gaps >= mid, so mid works; try an even bigger gap
                left = mid;
            } else {
                // Can't fit k cows with gaps >= mid, so mid is too large
                right = mid - 1;
            }
        }

        // left == right is the largest possible minimum distance
        return left;
    }

    // Returns true if k cows can be placed so that every neighbouring pair is at least 'dist' apart
    private static boolean canPlace(int[] nums, int dist, int k) {
        int cows = 1;           // place the first cow in the first stall
        int lastPos = nums[0];  // position of the most recently placed cow

        for (int i = 1; i < nums.length; i++) {
            // Greedy: place the next cow at the earliest stall that is far enough from the last one
            if (nums[i] - lastPos >= dist) {
                cows++;
                lastPos = nums[i];
            }
        }

        // Valid only if we managed to place all k cows
        return cows >= k;
    }

    public static void main(String[] args) {
        // Each test: nums[], k, expected answer
        int[][] stalls = {
                {0, 3, 4, 7, 10, 9},   // Example 1: cows at 0, 3, 7, 10
                {4, 2, 1, 3, 6},       // Example 2: cows at 1, 6
                {1, 2, 4, 8, 9}        // Extra: cows at 1, 4, 8
        };
        int[] ks = {4, 2, 3};
        int[] expected = {3, 5, 3};

        for (int i = 0; i < stalls.length; i++) {
            int actual = aggressiveCows(stalls[i], ks[i]);
            String status = (actual == expected[i]) ? "PASS" : "FAIL";
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + " -> " + status);
        }
    }
}