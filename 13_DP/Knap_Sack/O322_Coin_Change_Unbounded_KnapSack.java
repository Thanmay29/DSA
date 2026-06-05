package DP.Knap_Sack;

import java.util.Arrays;

public class O322_Coin_Change_Unbounded_KnapSack {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int tar = 11;
        System.out.println(tab(coins, tar));
    }

    public static int tab(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int coin : coins){
            for(int i=coin; i<=amount; i++){
                dp[i] = Math.min(dp[i], dp[i - coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
