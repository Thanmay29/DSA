package Binary_Search.BS_On_1D_Array;

public class O13_162_Find_Peak_Element {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Increasing slope
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            // Decreasing slope
            else {
                right = mid;
            }
        }
        return left; // or right (both same)
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums1)); // 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums2)); // 1 or 5
    }
}
