package DP;

public class O20_123_Buy_And_Sell_Stocks_3 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(best(prices));
    }

    public static int best(int[] prices){
        if(prices==null || prices.length<2) return 0;

        int n = prices.length;
        int profit = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        int min = prices[0];
        for(int i=1; i<n; i++){
            if(prices[i]<min){
                min = prices[i];
            }
            left[i] = Math.max(left[i-1], prices[i]-min);
        }

        int max = prices[n-1];
        for(int i=n-2; i>=0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max-prices[i]);
        }

        for(int i=0; i<n; i++){
            profit = Math.max(profit, left[i]+right[i]);
        }

        return profit;
    }
}
