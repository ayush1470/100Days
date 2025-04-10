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