package Sliding_Window;

public class O08_209_Minimum_Size_SubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, len = Integer.MAX_VALUE;

        for(int right = 0; right<nums.length; right++){
            sum+=nums[right];

            while(sum>=target){
                len = Math.min(len, right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return (len == Integer.MAX_VALUE) ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 4, 4};
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1};

        int target1 = 7;
        int target2 = 4;
        int target3 = 11;

        System.out.println("Output 1: " + minSubArrayLen(target1, nums1)); // Expected: 2 ([4,3])
        System.out.println("Output 2: " + minSubArrayLen(target2, nums2)); // Expected: 1 ([4])
        System.out.println("Output 3: " + minSubArrayLen(target3, nums3)); // Expected: 0 (no subarray)
    }
}
