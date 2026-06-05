package DP;

public class O19_122_Buy_And_Sell_Stocks_2 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(best(prices));
    }

    public static int best(int[] prices){
        int n = prices.length;
        int profit = 0;

        for(int i = 0; i<n-1; i++){
            if(prices[i]<prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }

        return profit;
    }
}
