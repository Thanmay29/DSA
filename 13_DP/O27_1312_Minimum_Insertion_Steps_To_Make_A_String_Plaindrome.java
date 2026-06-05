package DP;

import java.util.Arrays;

public class O27_1312_Minimum_Insertion_Steps_To_Make_A_String_Plaindrome {
    public static void main(String[] args) {
        String s = "mbadm";
        //Recursion
        System.out.println(recur(s, 0, s.length()-1));

        //Tabulation
        System.out.println(tab(s));
    }

    //Reursion
    public static int recur(String s, int left, int right){
        if(left >= right) return 0;

        if(s.charAt(left) == s.charAt(right)){
            return  recur(s, left+1, right-1);
        }else{
            return 1 + Math.min(recur(s, left+1, right), recur(s, left, right-1));
        }
    }
        //Tabulation
    public static int tab(String s){
        int n = s.length();

        String rev = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return n - dp[n][n];
    }
}
