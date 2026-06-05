package Prefix_Sum_Suffix_Kadane;

import java.util.Arrays;

public class O03_303_Range_Sum_Query_Immutable {

    private int[] prefix;

    // Constructor
    public O03_303_Range_Sum_Query_Immutable(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    // Query method
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }

    // Main method
    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        O03_303_Range_Sum_Query_Immutable obj =
                new O03_303_Range_Sum_Query_Immutable(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("sumRange(0, 2) = " + obj.sumRange(0, 2)); // 1
        System.out.println("sumRange(2, 5) = " + obj.sumRange(2, 5)); // -1
        System.out.println("sumRange(0, 5) = " + obj.sumRange(0, 5)); // -3
    }
}
