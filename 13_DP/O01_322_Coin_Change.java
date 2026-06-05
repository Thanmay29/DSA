package DP;

import java.util.Arrays;

public class O01_322_Coin_Change {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        //recursion
//        System.out.println(recur(coins, amount));

        //Memorisation
        System.out.println(memo(coins,amount));

        //Tabulation
//        System.out.println(tab(coins, amount));
    }

    //Recursive(Brute-Force)

    public static int recur(int[] coins, int amount){
        //Base-Case
        if(amount==0) return 0;

        //Invalid case
        if(amount<0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int subMin = recur(coins, amount-coin);
            if(subMin != Integer.MAX_VALUE){
                min = Math.min(min, subMin+1);
            }
        }

        return min;
    }


    //Memorisation
    public static int memo(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int res = minCost(coins, amount, dp);
        return (res==Integer.MAX_VALUE) ? -1 : res;
    }

    private static int minCost(int[] coins, int amount, int[] dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;

        if(dp[amount] != Integer.MAX_VALUE) return dp[amount];

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int subMin = minCost(coins, amount-coin, dp);
            if(subMin != Integer.MAX_VALUE){
                min = Math.min(min, subMin+1);
            }
        }

        return dp[amount] = min;
    }

    //Tabulation(Botton-Up Approach)

    public static int tab(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int coin : coins){
            for(int i = coin; i<=amount; i++){
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
