/* LeetCode Problem: (121) Best Time to Buy and Sell Stock  */

public class Day2Main{
    public static int CalculateMaxProfit(int[] prices){
        int BuyPrice = prices[0];
        int profit;
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(BuyPrice<=prices[i]){  // prices[i] is Selling Price here.
                profit = prices[i] - BuyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                BuyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(CalculateMaxProfit(prices));
    }
}

/* Logic: Profit = Selling Price - Buying Price.
          We don't buy and sell on the same day,
          and we equate Buying Price to the current stock price if
          the current Stock price is less than the Buying Price as
          that way the smallest value in the prices array is going to
          be allotted to the Buying Price which we want for Maximum Profit. */