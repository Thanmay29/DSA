package DP;

// LeetCode problem 746
public class O03_746_Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        int[] costs = {1,100,1,1,1,100,1,1,100,1};

        // Recursion
//        int res = Math.min(recur(costs, 0), recur(costs, 1));//Start from 0 or 1
//        System.out.println(res);


        //Memorisation
//        int[] dp = new int[costs.length];// dp Array creation
//        // Initialize array with -1 or Integer.MIN_VALUE or Integer.MAX_VALUE accordingly
//        Arrays.fill(dp, -1);
//        int res = Math.min(memo(costs, 0, dp), memo(costs, 1, dp));
//        System.out.println(res);


        //Tabulation
        int res = tab(costs);
        System.out.println(res);
    }

    //Recursion (Brte-Force Approach)
    public static int recur(int[] costs, int idx){
        if(idx>=costs.length) return 0;// Base Case
        return costs[idx] + Math.min(recur(costs, idx+1), recur(costs, idx+2));// Recursive Relation
    }


    //Memorisation (Top-Down Approach)
    public static int memo(int[] costs, int idx, int[] dp){
        if(idx>=costs.length) return 0; // Base Case

        //return the value if its already computed
        if(dp[idx] != -1) return dp[idx];
        return costs[idx] + Math.min(memo(costs, idx+1, dp), memo(costs, idx+2, dp));
    }


    //Tabulation (Bottom-Up Approach)
    public static int tab(int[] costs){
        int n = costs.length;
        //Create dp array n+1
        int[] dp = new int[n+1];
        //Base Cases or Initialzation
        dp[0] = costs[0];
        dp[1] = costs[1];

        //looping
        for(int i=2; i<n; i++){
            dp[i] = costs[i] + Math.min(dp[i-1], dp[i-2]);
        }

//        int[] costs = {1,100,1,1,1,100,1,1,100,1};
//        dp array = {1, 101, 2, 3, 3, 103, 4, 5, 105, 6};

        // return least of last two steps which is Min(105, 6);
        return Math.min(dp[n-1], dp[n-2]);//Min cost from last two
    }
}
