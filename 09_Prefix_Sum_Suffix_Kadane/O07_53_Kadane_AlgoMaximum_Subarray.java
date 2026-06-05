package Prefix_Sum_Suffix_Kadane;

public class O07_53_Kadane_AlgoMaximum_Subarray {
    public static void main(String[] args) {
        int[] nums = {-2, 2, -3, 4, -1, 2};
        System.out.println(sol(nums));
    }

    public static int sol(int[] nums){
        if(nums.length==0 || nums==null){
            return 0;
        }

        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
