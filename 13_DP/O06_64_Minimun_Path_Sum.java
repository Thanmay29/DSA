package DP;

import java.util.Arrays;

//LeetCode problem 64
public class O06_64_Minimun_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2 ,1}};

        //Recursion
//        int res = recur(grid, 0, 0);
//        System.out.println(res);

        //Memorisation
        int res = memo(grid);
        System.out.println(res);


        //Tabulation
//        int res = tab(grid);
//        System.out.println(res);
    }

    //Recursion (Brute-Force)
    public static int recur(int[][] grid, int i, int j){
        //Base Case
        if(i==grid.length-1 && j== grid[0].length-1) return grid[i][j];
        //out of Bound Check
        // return Integer.MAX_VALUE instead of 0
        // because it incorrectly affects the minimum path sum calculation
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;

        int right = recur(grid, i,j+1);
        int down = recur(grid, i+1, j);

        return grid[i][j] + Math.min(right, down);
    }


    //Memorisation (Top-Down Approach)
    public static int memo(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);
        return minCostMemo(grid, n-1,m-1, dp);
    }

    public static int minCostMemo(int[][] grid, int i, int j, int[][] dp){
        //Base-Case
        if(i == 0 && j == 0) return grid[i][j];

        if(i<0 || j<0) return Integer.MAX_VALUE;

        //if already computed return
        if(dp[i][j] != -1) return dp[i][j];

        int up = minCostMemo(grid, i-1, j, dp);
        int left = minCostMemo(grid, i, j-1, dp);

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }


    //Tabulation (Bottom-Up Approach)
    public static int tab(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        //dp array
        int[][] dp = new int[n+1][m+1];
        //Initialization
        dp[0][0] = grid[0][0];

        //Fill the first row same as grid to the dp
        for(int i=1; i<n ;i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        //Fill the first column same as grid
        for(int j=1; j<m; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }

        //compute / fill the rest of the dp table
        for(int i=1; i<n; i++){
            for(int j=1; j<m ;j++){
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = grid[i][j] + Math.min(left, up);
            }
        }
        return dp[n-1][m-1];
    }
}
