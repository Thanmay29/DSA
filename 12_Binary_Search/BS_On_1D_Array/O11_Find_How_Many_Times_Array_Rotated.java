package Binary_Search.BS_On_1D_Array;

public class O11_Find_How_Many_Times_Array_Rotated {

    // Returns number of rotations
    public static int rotationCount(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Minimum is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Minimum is in left half (including mid)
            else {
                right = mid;
            }
        }
        return left; // index of minimum element
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(rotationCount(nums1)); // 3

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(rotationCount(nums2)); // 4

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(rotationCount(nums3)); // 0 (not rotated)
    }
}
