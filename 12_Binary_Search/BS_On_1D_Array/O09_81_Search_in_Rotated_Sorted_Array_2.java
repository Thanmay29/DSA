package Binary_Search.BS_On_1D_Array;

public class O09_81_Search_in_Rotated_Sorted_Array_2 {

    // Method to search target in rotated sorted array with duplicates
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println(search(nums1, target1)); // true

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println(search(nums2, target2)); // false

        int[] nums3 = {1, 1, 1, 1, 1};
        int target3 = 1;
        System.out.println(search(nums3, target3)); // true

        int[] nums4 = {1, 0, 1, 1, 1};
        int target4 = 0;
        System.out.println(search(nums4, target4)); // true
    }
}

