package Sliding_Window;

public class O23_930_Binary_Subarrays_with_Sum {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        // exact(sum == goal) = atMost(sum <= goal) - atMost(sum <= goal-1)
        // subarrays with sum 0..goal-1 exist in both counts and cancel out,
        // leaving only the ones with sum == goal
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    // counts the number of subarrays with sum <= goal
    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0; // sum can never be negative, so no valid subarrays

        int sum = 0, left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            // expand window: include nums[right]
            sum += nums[right];

            // shrink from left while window sum exceeds the allowed goal
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            // every subarray [start, right] for start in [left, right]
            // has sum <= goal, since sum only increases as start moves left.
            // there are (right - left + 1) such subarrays ending at 'right'.
            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 1, 0, 1};
        int goal1 = 2;
        System.out.println("Output: " + numSubarraysWithSum(nums1, goal1)); // Expected: 4

        int[] nums2 = {0, 0, 0, 0, 0};
        int goal2 = 0;
        System.out.println("Output: " + numSubarraysWithSum(nums2, goal2)); // Expected: 15
    }
}