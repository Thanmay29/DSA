package Array;

import java.util.Arrays;

public class O10_Rotate_Array {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int k = 3;
        sol(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void sol(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotateArray(nums, 0, n - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, n - 1);
    }

    public static void rotateArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
