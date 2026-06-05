package DP;

import java.util.Arrays;

public class O25_1143_Longest_Common_Subsequence_SubStrinig {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        //Recursion
        System.out.println(recur(s1, s2, s1.length()-1, s2.length()-1));

        //Memorisation
        System.out.println(memo(s1, s2));
        //Tabulation
        System.out.println(tab(s1, s2));
    }

    //Recursion
    public static int recur(String text1, String text2, int i, int j){
        if(i<0 || j<0) return 0;

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + recur(text1, text2, i-1, j-1);
        }else{
            return Math.max(recur(text1, text2, i-1, j), recur(text1, text2, i, j-1));
        }
    }

    //Memorisation
    public static int memo(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(text1, text2, m-1, n-1, dp);
    }
    public static int helper(String text1, String text2, int i, int j, int[][] dp){

        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + helper(text1, text2, i-1, j-1, dp);
        }else{
            dp[i][j] = Math.max(helper(text1, text2, i-1, j, dp), helper(text1, text2, i, j-1, dp));
        }
        return dp[i][j];
    }

    //Tabulation
    public static int tab(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m; i++){
            for(int j=1;j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        return dp[m][n];
    }
}
