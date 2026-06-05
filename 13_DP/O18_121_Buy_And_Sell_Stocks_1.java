package DP;

public class O18_121_Buy_And_Sell_Stocks_1 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(best(prices));

        //recursion
        System.out.println(recur(prices, 0, Integer.MAX_VALUE, 0));
    }

    public static int best(int[] prices){
        int n = prices.length;
        int profit = 0;
        int buy = prices[0];

        for(int i=1; i<n; i++){
            if(prices[i]<buy){
                buy = prices[i];
            }else{
                profit = Math.max(profit, prices[i] - buy);
            }
        }

        return profit;
    }

    //Recursion
    public static int recur(int[] prices, int idx, int minPrice, int maxProfit){
        if(idx == prices.length) return maxProfit;

        minPrice = Math.min(minPrice, prices[idx]);
        maxProfit = Math.max(maxProfit, prices[idx] - minPrice);

        return recur(prices, idx+1, minPrice, maxProfit);
    }
}
