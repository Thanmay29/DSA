package DP.Knap_Sack;

public class O416_Partition_Equal_Subset_Sum_01_KnapSack {
    public static void main(String[] args) {
        int[] arr = {3, 5};
        System.out.println(tab(arr));
    }

    public static boolean tab(int[] arr){
        int sum = 0;
        for(int num : arr){
            sum+=num;
        }

        if(sum % 2 != 0){
            return false;
        }

        int tar = sum/2;
        boolean[] dp = new boolean[tar+1];
        dp[0] = true;

        for(int num : arr){
            for(int i = num; i<=tar; i++){
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[tar];
    }
}
