package Array;

public class O24_334_Increasing_Triplet_Subsequence {
    public static void main(String[] args) {

        //Example 1:=
        //Input: nums = [1,2,3,4,5]
        //Output: true
        //Explanation: Any triplet where i < j < k is valid.

        //Example 2:=
        //Input: nums = [5,4,3,2,1]
        //Output: false
        //Explanation: No triplet exists.

        //Example 3:
        //Input: nums = [2,1,5,0,4,6]
        //Output: true
        //Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums));

        int[] nums1 = {5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(nums1));

        int[] nums2 = {2, 1, 5, 0, 4, 6};
        System.out.println(increasingTriplet(nums2));
    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // Update the smallest number
            } else if (num <= second) {
                second = num; // Update the second smallest number
            } else {
                return true; // Found a third number that is greater than 'second'
            }
        }

        return false;
    }
}
