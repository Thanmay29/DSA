package DP;

import java.util.Arrays;

public class O08_279_Perfect_Square {
    public static void main(String[] args) {
        int n = 12;

        //Recursion
//        System.out.println(recur(n));

        //Memorisation
//        System.out.println(memo(n));

        //Tabulation
        System.out.println(tab(n));
    }

    //Recursion(Brute-Force)
    public static int recur(int n){
        //Base-Case
        if(n==0) return 0;

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            min = Math.min(min, recur(n-i*i) + 1);
        }
        return min;
    }

    //Memorisation(Top-Down)
    public static int memo(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        return helper(n, dp);
    }

    public static int helper(int n, int[] dp){
        if(n==0) return 0;

        if(dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n ;i++){
            min = Math.min(min, helper(n-i*i, dp) + 1);
        }

        return min;
    }

    //Tabulation
    public static int tab(int n){
        if(n==0) return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[n];
    }
}
