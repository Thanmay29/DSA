package DP;

import java.util.Arrays;

public class O02_650_Keys_Keyboard {

//    You have a notepad where initially you have only one character 'A'.
//You can perform only two operations:
//Copy All → Copy all the characters on the screen into the clipboard.
//Paste → Paste the clipboard content onto the screen (adds to existing characters).
//👉 The goal: Find the minimum number of operations needed to print exactly n 'A's on the screen.
    public static void main(String[] args) {
        int n = 6;

        //Recursive
//        System.out.println(recur(n));

        //Memrorisation
//        System.out.println(memo(n));

        //Tabulation
        System.out.println(tab(n));
    }


    //Recursive(brute-Force)
    public static int recur(int n){
        //Base case
        if(n==1) return 0;

        int min = n;

        for(int i=n-1; i>0; i--){
            if(n%i == 0){
                min = Math.min(min, recur(i) + (n/i));
            }
        }
        return min;
    }

    //Memorisation(Top-Down)
    public static int memo(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public static int helper(int n, int[] dp){
        //Base case
        if(n==1) return 0;

        //check if the result is already computed
        if(dp[n] != -1) return dp[n];

        int min = n;

        for(int i=n-1; i>0; i--){
            if(n%i == 0){
                min = Math.min(min, helper(i, dp) + (n/i));
            }
        }
        return min;
    }


    //Tabulation(Bottom-Up) approach
    public static int tab(int n){
        if(n==1) return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for(int i=2; i<=n; i++){
            for(int j=1;j<i; j++){
                if(i%j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + (i/j));
                }
            }
        }
        return dp[n];
    }
}
