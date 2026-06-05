package DP;

import java.util.Arrays;

public class O04_931_Min_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        // Recursion
//        System.out.println(recur(matrix));

        //Memorisation
//        System.out.println(memo(matrix));

        //Tabulation
        System.out.println(tab(matrix));
    }



    //Recursion
    public static int recur(int[][] matrix) {
        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, helper(matrix, 0, col));
        }

        return minSum;
    }

    public static int helper(int[][] matrix, int row, int col) {
        int n = matrix.length;

        // **Base Cases**
        if (col < 0 || col >= n) return Integer.MAX_VALUE;  // Out-of-bounds check
        if (row == n - 1) return matrix[row][col]; // If at last row, return its value

        // **Recursive Calls**
        int left = helper(matrix, row + 1, col - 1);   // Move diagonally left
        int down = helper(matrix, row + 1, col);       // Move straight down
        int right = helper(matrix, row + 1, col + 1);  // Move diagonally right

        return matrix[row][col] + Math.min(left, Math.min(down, right));
    }

    //Memorisation
    public static int memo(int[][] matrix){
        int n = matrix.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        int sum = Integer.MAX_VALUE;
        for(int col=0; col<n; col++){
            sum = Math.min(sum, helper(matrix, 0, col, dp));
        }
        return sum;
    }

    public static int helper(int[][] matrix, int row, int col, int[][] dp){
        int n = matrix.length;

        if(col<0 || col>=n-1) return Integer.MAX_VALUE;

        if(row==n-1) return matrix[row][col];

        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int left = helper(matrix, row+1, col-1, dp);
        int down = helper(matrix, row+1, col, dp);
        int right = helper(matrix,row+1,col+1, dp);

        return dp[row][col] = matrix[row][col] + Math.min(left, Math.min(down, right));
    }


    //Tabulation(Botton-Up)
    public static int tab(int[][] matrix){
        int n = matrix.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        for(int col=0; col<n; col++){
            dp[n-1][col] = matrix[n-1][col];
        }

        for(int row=n-2; row>=0; row--){
            for(int col=1; col<n; col++){
                int left = (col>0) ? dp[row+1][col-1] : Integer.MAX_VALUE;
                int down = dp[row+1][col];
                int right = (col<n-1) ? dp[row+1][col+1] : Integer.MAX_VALUE;

                dp[row][col] = matrix[row][col] + Math.min(left, Math.min(down, right));
            }
        }

        int sum = Integer.MAX_VALUE;
        for(int col=0; col<n; col++){
            sum = Math.min(sum, dp[0][col]);
        }

        return sum;

    }
}
