package DP.Knap_Sack;

import java.util.Arrays;

public class O04_494_Target_Sum_01_KnapSack {
    public static void main(String[] args) {
        //Create object Main class
        //Main_Class_name  Object_name = new Main_Class_Name();
        O04_494_Target_Sum_01_KnapSack KS = new O04_494_Target_Sum_01_KnapSack();
        int[] nums = {1, 1, 1, 1, 1};
        int tar = 3;
        System.out.println(KS.tab(nums, tar));
    }

    public int tab(int[] nums, int target){
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) return 0; // Invalid case

        int P = (sum + target) / 2;
        return subsetSum(nums, P);
    }

    private int subsetSum(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // Base case: One way to make sum 0 (by selecting nothing)

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }
}
