package DP;

import java.util.Arrays;

public class O26_72_Edit_Distance_GOGGLE_IMP {
    public static void main(String[] args) {
        String w1 = "horse";
        String w2 = "ros";

        //Recursion
        System.out.println(recur(w1, w2, w1.length(), w2.length()));

        //Memorisation
        System.out.println(memo(w1, w2));

        //Tabulation
        System.out.println(tab(w1, w2));
    }

    //Recursion
    public static int recur(String w1, String w2, int m, int n){
        if(n==0) return m;
        if(m==0) return n;

        if(w1.charAt(m-1) == w2.charAt(n-1)){
            return recur(w1, w2, m-1, n-1);
        }else{
            return 1 + Math.min(recur(w1, w2, m-1, n), Math.min(recur(w1, w2, m, n-1), recur(w1, w2, m-1, n-1)));
        }
    }

    //Memorisation
    public static int memo(String w1, String w2){
        int m = w1.length();
        int n = w2.length();

        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        for(int i=0; i<=m; i++) dp[i][0] = i;
        for(int j=0; j<=n; j++) dp[0][j] = j;

        return helper(w1, w2, m, n, dp);
    }

    public static int helper(String w1, String w2, int m, int n, int[][] dp){
        if(n==0)return m;
        if(m==0)return n;

        if(dp[m][n] != Integer.MAX_VALUE) return dp[m][n];

        if(w1.charAt(m-1) == w2.charAt(n-1)){
            dp[m][n] =  helper(w1, w2, m-1, n-1, dp);
        }else{
            dp[m][n] = 1 + Math.min(
                    helper(w1, w2, m - 1, n, dp),   // Delete
                    Math.min(
                            helper(w1, w2, m, n - 1, dp), // Insert
                            helper(w1, w2, m - 1, n - 1, dp) // Replace
                    )
            );
        }

        return dp[m][n];
    }
    //Tabulation
    public static int tab(String w1, String w2){
        int m = w1.length();
        int n = w2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) dp[i][0] = i; //Deletion
        for(int j=0; j<=n;j++) dp[0][j] = j; //Insertion

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(w1.charAt(i-1) == w2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // No operation needed
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],   //Deletion
                                        Math.min(dp[i][j-1], //Insertion
                                                dp[i-1][j-1]));//Replace
                }
            }
        }

        return dp[m][n];
    }
}
