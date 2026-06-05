package DP.Knap_Sack;

import java.util.HashSet;
import java.util.Set;

public class O983_Min_Cost_For_Tickets_Unbounded_Knapsack {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(tab(days, costs));
    }

    public static int tab(int[] days, int[] costs){
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];

        Set<Integer> set = new HashSet<>();
        for(int day : days){
            set.add(day);
        }

        for(int i=1; i<=lastDay; i++){
            if(!set.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }

            int oneDay = dp[i-1] + costs[0];
            int sevenDay = dp[Math.max(0, i-7)] + costs[1];
            int thirtyDay = dp[Math.max(0, i-30)] + costs[2];

            dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        }

        return dp[lastDay];
    }
}
