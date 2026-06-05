package DP;

public class O28_516_Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        //Recursion
        System.out.println(recur(s));

        //tabulation(optimal)
        System.out.println(tab(s));
    }

    //Recursion
    public static int recur(String s){
        return helper(s, 0, s.length()-1);
    }

    public static int helper(String s, int left, int right){
        if(left>right) return 0;
        if(left==right) return 1;

        if(s.charAt(left) == s.charAt(right)){
            return 2 + helper(s, left+1, right-1);
        }else{
            return Math.max(helper(s, left+1, right), helper(s, left, right-1));
        }

    }

    //Tabulation(Optimal)
    public static int tab(String s){
        int n = s.length();
        int[][] dp = new int[n][n];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the table in a bottom-up manner
        for (int len = 2; len <= n; len++) { // Substring lengths from 2 to n
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // End of substring

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1]; // Include both characters
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]); // Exclude one
                }
            }
        }

        return dp[0][n-1]; // Answer for the entire string
    }
}
