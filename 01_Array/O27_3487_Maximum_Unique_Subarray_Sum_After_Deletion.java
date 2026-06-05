package Array;

import java.util.Arrays;

public class O27_3487_Maximum_Unique_Subarray_Sum_After_Deletion {

    public static int maxSum(int[] nums) {
        Arrays.sort(nums); // 🔃 Step 1: Sort the array

        int previous = nums[nums.length - 1]; // Largest number
        int result = previous; // Initialize result with largest

        for (int index = nums.length - 2; index >= 0; index--) {

            int currentValue = nums[index];

            if (currentValue <= 0) return result; // 🚫 Stop at zero or negative

            if (currentValue != previous) result += currentValue; // ✅ Add if unique

            previous = currentValue; // Update previous
        }

        return result;
    }

    public static void main(String[] args) {
        // 📌 Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Output: " + maxSum(nums1)); // Expected: 15

        // 📌 Test Case 2
        int[] nums2 = {1, 1, 0, 1, 1};
        System.out.println("Output: " + maxSum(nums2)); // Expected: 1

        // 📌 Test Case 3
        int[] nums3 = {1, 2, -1, -2, 1, 0, -1};
        System.out.println("Output: " + maxSum(nums3)); // Expected: 3

        int[] nums4 = {-2, -3};
        System.out.println("Output: " + maxSum(nums4)); // Expected: -2
    }
}
