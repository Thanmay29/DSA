package DP;

import java.util.Arrays;

public class O11_416_Partition_Equal_Subset_Sum_KnapSack_01 {
    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        //recursion
        System.out.println(recur(nums));

        //tabulation
//        System.out.println(tab(nums));
    }

    //Recursion
    public static boolean recur(int[] nums){

        int sum = Arrays.stream(nums).sum();

        if(sum %2 != 0) return false;
        return isSubset(nums, nums.length-1, sum/2);
    }

    public static boolean isSubset(int[] nums, int idx, int tar){
        if(tar == 0) return true;
        if(idx < 0 || tar < 0) return false;

        boolean exclude = isSubset(nums, idx-1, tar);

        boolean include = false;

        if(nums[idx] <= tar){
            include = isSubset(nums, idx-1, tar-nums[idx]);
        }

        return include || exclude;
    }


    //Memorisation
    public static boolean memo(int[] nums){
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        int tar = sum/2;
        int[][] dp = new int[nums.length][tar+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(nums, nums.length-1, tar, dp);
    }

    public static boolean helper(int[] nums, int idx, int tar, int[][] dp){
        if(tar == 0) return true;
        if(idx<0 || tar<0) return false;

        if(dp[idx][tar] != -1) return dp[idx][tar] == 1;

        boolean exclude = helper(nums, idx-1, tar, dp);
        boolean include = false;

        if(nums[idx]<=tar){
            include = helper(nums,idx-1, tar-nums[idx], dp);
        }

        dp[idx][tar] = (include || exclude) ? 1 : 0;
        return include || exclude;
    }


    //Tabulation
    public static boolean tab(int[] nums){
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0) return false;

        int tar = sum/2;

        //if we can make half subset sum then the half is possible
        boolean[] dp = new boolean[tar+1];
        dp[0] = true;//subset of 0 is always true

        for(int num : nums){
            for(int j=num; j<=tar; j++){
                dp[j] = dp[j] || dp[j-num];//OR operation
            }
        }

        return dp[tar];
    }
}
