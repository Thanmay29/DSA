package DP;
import java.util.Arrays;
public class O10_576_Out_Of_Boundary_Path {
    private static final int MOD = 1_000_000_007;
    private int[][][] dp;

    public static void main(String[] args) {

        O10_576_Out_Of_Boundary_Path obj = new O10_576_Out_Of_Boundary_Path();
        int m = 2, n = 2, maxMove = 2, startRow = 0, startCol = 0;
        //Recursion
//        System.out.println(recur(m, n,maxMove,startRow, startCol));

        //Memorisation
//        System.out.println(obj.memo(m, n, maxMove, startRow, startCol));

        //Tabulation
        System.out.println(tab(m, n, maxMove, startRow, startCol));
    }

    //Recursion
    public static int recur(int m, int n, int moves, int row, int col){
        return helperDFS(m, n, moves, row, col);
    }

    public static int helperDFS(int m, int n, int moves, int row, int col){
        if(row<0 || col<0 || row>=m || col>=n) return 1;
        if(moves == 0) return 0;

        int paths = 0;

        paths = paths + helperDFS(m, n, moves-1, row+1, col)%MOD;
        paths = paths + helperDFS(m, n, moves-1, row-1, col)%MOD;
        paths = paths + helperDFS(m, n, moves-1, row, col+1)%MOD;
        paths = paths + helperDFS(m, n, moves-1, row, col-1)%MOD;

        return paths;
    }


    //Memorisation
    public int memo(int m, int n, int maxMove, int startRow, int startCol){
        dp = new int[m][n][maxMove+1];

        for(int[][] layer : dp){
            for(int[] row : layer){
                Arrays.fill(row, -1);
            }
        }
        return dfs(m, n, maxMove, startRow, startCol);
    }

    private int dfs(int m, int n, int move, int row, int col){
        //Base Case
        if(row<0 || col<0 || row>=m || col>=n) return 1;
        if(move == 0) return 0;

        if(dp[row][col][move] != -1) return dp[row][col][move];

        long paths = 0;
        paths = (paths + dfs(m, n, move-1, row+1, col)) % MOD;
        paths = (paths + dfs(m, n, move-1, row-1, col)) % MOD;
        paths = (paths + dfs(m, n, move-1, row, col+1)) % MOD;
        paths = (paths + dfs(m, n, move-1, row, col-1)) % MOD;

        dp[row][col][move] = (int) paths;
        return dp[row][col][move];
    }


    //Tabulation
    public static int tab(int m, int n, int maxmoves, int startrow, int startcol){
       int[][][] dp = new int[m][n][maxmoves+1];

       for(int moves = 1; moves<=maxmoves; moves++){
           for(int row=0; row<m; row++){
               for(int col=0; col<n; col++){
                   long paths = 0;

                   if(row==0) paths++;
                   if(col==0) paths++;
                   if(row==m-1) paths++;
                   if(col==n-1) paths++;

                   if(row>0) paths+= dp[row-1][col][moves-1];
                   if(row<m-1) paths+=dp[row+1][col][moves-1];
                   if(col>0) paths+=dp[row][col-1][moves-1];
                   if(col<n-1) paths+=dp[row][col+1][moves-1];

                   dp[row][col][moves] = (int) (paths%MOD);

               }
           }
       }

       return dp[startrow][startcol][maxmoves];
    }
}
