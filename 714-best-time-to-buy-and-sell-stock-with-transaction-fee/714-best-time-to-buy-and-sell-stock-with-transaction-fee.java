class Solution {
    public int maxProfit(int[] prices, int fee) {
         int bought = prices[0];
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++)
        {
            bought = Math.min(bought, prices[i] - profit);
            profit = Math.max(profit,prices[i] - bought - fee);
        }
        
        return profit;
    }
}
//n