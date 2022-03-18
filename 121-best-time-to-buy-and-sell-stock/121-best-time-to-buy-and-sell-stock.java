class Solution {
    public int maxProfit(int[] prices) {
          int i,maxp=0,lo=prices[0];
        for(i=1;i<prices.length;i++)
        {
            if(lo>prices[i])
                lo=prices[i];
            maxp=Math.max(maxp,prices[i]-lo);
        }
        return maxp;
    }
}