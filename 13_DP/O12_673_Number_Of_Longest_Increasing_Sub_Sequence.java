package DP;

import java.util.Arrays;

public class O12_673_Number_Of_Longest_Increasing_Sub_Sequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};

        //Tabulation
        System.out.println(tab(nums));
    }


    //Tabulation
    public static int tab(int[] nums){
        int[] dp = new int[nums.length]; //To store Length of LIS ending at i
        int[] count = new int[nums.length]; //To store count of LIS (Longest Increasing SubSequence)
        int maxLen = 1, totalCount = 0;

        Arrays.fill(dp, 1);//Initially length of longest subsequence is 1 because the number itself is an longest subsequence
        Arrays.fill(count, 1);

        for(int i=0; i< nums.length; i++){
            for(int j=0; j<i ;j++){
                if(nums[i]>nums[j]){//Increasing subsequence  ...nums[i] = 3, nums[j] = 1; 3>1  [1, 3, 5, 4, 7]
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }else if(dp[j]+1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        for(int i=0; i<nums.length; i++){
            if(dp[i] == maxLen){
                totalCount+=count[i];
            }
        }

        return totalCount;
    }
}
