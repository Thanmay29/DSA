package DP.Knap_Sack;

import java.util.Arrays;

public class O05_1049_Last_Stone_Weight_II_01_KnapSack {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(tab(stones));
    }

    public static int tab(int[] stones){
        int sum = Arrays.stream(stones).sum();
        int tar = sum / 2;

        int[] dp = new int[tar + 1];

        for (int stone : stones) {
            // Reverse loop from tar to stone (not 0) to avoid overwriting values
            for (int i = tar; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }

        return sum - 2 * dp[tar]; // Final answer
    }
}
