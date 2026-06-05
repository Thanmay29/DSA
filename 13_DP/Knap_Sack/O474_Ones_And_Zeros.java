package DP.Knap_Sack;

public class O474_Ones_And_Zeros {
    public static void main(String[] args) {
        String[] str = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(tab(str, m, n));
    }

    public static int tab(String[] str, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for(String s: str){
            int zeros = countZeros(s);
            int ones = s.length() - zeros;

            for(int i=m; i>=zeros; i--){
                for(int j=n; j>=ones; j--){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-zeros][j-ones]);
                }
            }
        }

        return dp[m][n];
    }

    private static int countZeros(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                count++;
            }
        }
        return count;
    }
}
