package DP;

public class O32_115_Distinct_Subsequence {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t){
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // If t is an empty string, there is exactly one subsequence (empty subsequence)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Compute dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If characters match, we have two choices:
                    // 1. Use this character in the subsequence (dp[i-1][j-1])
                    // 2. Skip this character in s (dp[i-1][j])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters do not match, we can only skip s[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
