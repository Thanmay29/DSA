package Binary_Search.BS_On_1D_Array;

public class O10_153_Find_Minimum_in_Rotated_Sorted_Array {

    // Finds minimum element in rotated sorted array (no duplicates)
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Minimum lies in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Minimum lies in left half (including mid)
            else {
                right = mid;
            }
        }
        return nums[left];
    }

    // Main method for testing
    public static void main(String[] args) {

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums1)); // 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums2)); // 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums3)); // 11
    }
}
