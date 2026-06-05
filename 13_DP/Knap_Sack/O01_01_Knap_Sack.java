package DP.Knap_Sack;

public class O01_01_Knap_Sack {
    public static void main(String[] args) {
        int[] val = {10, 40, 50};
        int[] wt = {1, 3, 4};
        int cap = 5;
        int n = val.length;

        System.out.println(ks(n, val, wt, cap));
    }

    public static int ks(int n, int[] val, int[] wt, int cap){
        // Create a DP table with (n+1) rows and (cap+1) columns
        int dp[][] = new int[n + 1][cap + 1];

        // Build the DP table in a bottom-up manner
        for (int i = 0; i <= n; i++) { // Loop over items
            for (int c = 0; c <= cap; c++) { // Loop over capacity from 0 to cap
                if (i == 0 || c == 0) { // Base case: No items or 0 capacity
                    dp[i][c] = 0;
                } else if (wt[i - 1] <= c) {
                    // If the current item's weight is less than or equal to the current capacity
                    // We take the maximum of:
                    // 1. Including the current item: val[i-1] + dp[i-1][c - wt[i-1]]
                    // 2. Not including the current item: dp[i-1][c]
                    dp[i][c] = Math.max(val[i - 1] + dp[i - 1][c - wt[i - 1]], dp[i - 1][c]);
                } else {
                    // If the current item's weight is more than the current capacity, we can't include it
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }

        // Print the DP Table for visualization
        System.out.println("DP Table:");
        for (int i = 0; i <= n; i++) {
            for (int c = 0; c <= cap; c++) {
                System.out.print(dp[i][c] + "\t");
            }
            System.out.println();
        }

        // The last cell of the table contains the maximum value possible
        return dp[n][cap];
    }
}
