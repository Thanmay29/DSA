package Array;

import java.util.Arrays;

public class O34_75_Sort_Colors {

    static void sortColors(int[] nums){
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap 0 to the beginning
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in correct position
                mid++;
            } else {
                // Swap 2 to the end
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums= {2, 1, 0, 0, 2, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
