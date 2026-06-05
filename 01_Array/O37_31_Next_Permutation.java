package Array;

//[1, 2, 3]  ← current
//[1, 3, 2]  ← next permutation
//[2, 1, 3]
//[2, 3, 1]
//[3, 1, 2]
//[3, 2, 1]

import java.util.Arrays;

//It's like pressing the "next" button in a list of sorted options — it shows you the next greater option.
//If you're already at the last one, it resets to the beginning.
//the next greater arrangement of the entire array.
public class O37_31_Next_Permutation {

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. Find first decreasing element from the right
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1] ) {
            i--;
        }

        // 2. If found, find the element just larger than nums[i] from the right
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }

        // 3. Reverse the part from i+1 to end
        reverse(nums, i + 1, n - 1);
    }

    // Swap helper
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse helper
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1, 5, 1]
    }
}
