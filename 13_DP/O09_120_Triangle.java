package DP;

import java.util.*;

public class O09_120_Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );

//        System.out.println(recur(triangle));

//        System.out.println(memo(triangle));

        System.out.println(tab(triangle));
    }

    //Recursion
    public static int recur(List<List<Integer>> triangle){
        return helper(0, 0, triangle);
    }

    public static int helper(int row, int col, List<List<Integer>> triangle){
        int n = triangle.size();

        if(row == n-1) return triangle.get(row).get(col);

        int down = helper(row+1, col, triangle);
        int dia = helper(row+1, col+1, triangle);
        return triangle.get(row).get(col) + Math.min(down, dia);
    }


    //Memorisation
    public static int memo(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        return helper(0, 0, triangle, dp);
    }

    public static int helper(int row, int col, List<List<Integer>> triangle, int[][] dp){
        int n = triangle.size();
        if(row == n-1) return triangle.get(row).get(col);

        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int down = helper(row+1, col, triangle, dp);
        int dia = helper(row+1, col+1, triangle, dp);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(down, dia);
    }

    //Tabuation
    public static int tab(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][]dp = new int[n][n];

        for(int col=0; col<n; col++){
            dp[n-1][col]= triangle.get(n-1).get(col);
        }

        for(int row=n-2; row>=0; row--){
            for(int col=0; col<=row; col++){
                dp[row][col] = triangle.get(row).get(col) + Math.min(dp[row+1][col], dp[row+1][col+1]);
            }
        }

        return dp[0][0];
    }
}
