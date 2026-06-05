package DP;

public class O31_44_Wildcard_Matching {
    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(sol(s, p));
    }

    public static boolean sol(String s, String p){
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: both string and pattern are empty
        dp[0][0] = true;

        // Handle cases where pattern contains '*' at the beginning
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1]; // '*' can match empty string
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1); // Current character in s
                char pc = p.charAt(j - 1); // Current character in p

                if (pc == sc || pc == '?') { // Exact match or '?' match
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' can match zero characters (dp[i][j-1]) or multiple characters (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
