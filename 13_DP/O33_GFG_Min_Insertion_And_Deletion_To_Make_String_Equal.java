package DP;

public class O33_GFG_Min_Insertion_And_Deletion_To_Make_String_Equal {
    public static void main(String[] args) {
        String s = "abab", t = "baba";
        System.out.println(minOperations(s, t));
    }
        public static int minOperations(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();

            // Step 1: Compute LCS length
            int lcsLength = longestCommonSubsequence(s1, s2);

            // Step 2: Compute operations
            int deletions = m - lcsLength;
            int insertions = n - lcsLength;

            return deletions + insertions;
        }

        // Helper function to compute LCS using Dynamic Programming
    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

    }
}
