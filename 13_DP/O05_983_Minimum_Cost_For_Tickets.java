package DP;

import java.util.Arrays;
import java.util.HashSet;

public class O05_983_Minimum_Cost_For_Tickets {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        //Recusion
//        int res = recur(days, 0, costs);
//        System.out.println(res);

        //Memorisation

        int res = memo(days, costs);
        System.out.println(res);

        //Tabulation
//        int res = tab(days, costs);
//        System.out.println(res);
    }

    //Recusion(Brute-Force)

    public static int recur(int[] days,int idx, int[] costs){
        if(idx>=days.length) return 0;

        int cost1 = costs[0] + recur(days, idx+1, costs);

        int i = idx;
        while(i < days.length && days[i] < days[idx] + 7) i++;
        int cost7 = costs[1] + recur(days, i, costs);

        i = idx;
        while(i < days.length && days[i] < days[idx] + 30) i++;
        int cost30 = costs[2] + recur(days, i, costs);

        return Math.min(cost1, Math.min(cost7, cost30));
    }

    //Memorization(Top-Down Approach)

    public static int memo(int[] days, int[] costs){
        int n = days.length;
        int[] dp = new int[n]; // Memoization array
        Arrays.fill(dp, -1); // Fill with -1 to indicate uncomputed states
        return minCost(0, days, costs, dp);
    }

    private static int minCost(int index, int[] days, int[] costs, int[] dp) {
        if (index >= days.length) return 0; // Base case: No more days left to process
        if (dp[index] != -1) return dp[index]; // Return cached result if computed

        // Option 1: Buy a 1-day pass
        int cost1 = costs[0] + minCost(nextIndex(index, days, days[index] + 1), days, costs, dp);

        // Option 2: Buy a 7-day pass
        int cost7 = costs[1] + minCost(nextIndex(index, days, days[index] + 7), days, costs, dp);

        // Option 3: Buy a 30-day pass
        int cost30 = costs[2] + minCost(nextIndex(index, days, days[index] + 30), days, costs, dp);

        // Store and return the minimum cost for the current index
        return dp[index] = Math.min(cost1, Math.min(cost7, cost30));
    }

    private static int nextIndex(int index, int[] days, int nextDay) {
        // Find the next index where days[index] >= nextDay
        while (index < days.length && days[index] < nextDay) {
            index++;
        }
        return index;
    }



        //Tabulation (Bottom-Up Approach)
    public static int tab(int[] days, int[] costs){
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];

        HashSet<Integer> set = new HashSet<>();

        for(int day : days){
            set.add(day);
        }

        for(int i=1; i<=lastDay; i++){
            if(!set.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = Math.min(dp[i-1] + costs[0],
                    Math.min(dp[Math.max(0, i-7)] + costs[1],
                            dp[Math.max(0, i-30)] + costs[2]));
        }

        return dp[lastDay];
    }
}
