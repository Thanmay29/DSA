package Binary_Search.BS_On_1D_Array;

public class O12_540_Single_Element_in_a_Sorted_Array {

    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair is correct → single element on right side
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }
            // Pair is broken → single element on left side (including mid)
            else {
                right = mid;
            }
        }
        return nums[left];


    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums1)); // 2

        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums2)); // 10
    }
}
