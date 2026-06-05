package DP.Knap_Sack;

public class O02_Unbounded_Knap_Sack {
    public static void main(String[] args) {
        int[] wt = {2, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int w = 8;//Capacity

        System.out.println(uKS(wt, val, w));
    }

    public static int uKS(int[] wt, int[] val, int W){
        int[] dp = new int[W+1];
        int n = wt.length;

        for(int w = 0; w<=W; w++){
            for(int i=0; i<n; i++){
                if(wt[i]<=w){
                    dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
                }
            }
        }

        return dp[W];
    }
}
