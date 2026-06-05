package DP.Knap_Sack;

public class O03_518_Coin_Change_2_Unbounded_KnapSack {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int tar = 5;
        System.out.println(tab(coins, tar));
    }

    public static int tab(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: one way to make amount 0 (using no coins)

        for (int coin : coins) { // Process each coin
            for (int j = coin; j <= amount; j++) { // Update dp array
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
