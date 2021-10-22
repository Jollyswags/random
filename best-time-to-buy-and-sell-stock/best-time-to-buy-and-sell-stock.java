class Solution {
    public int maxProfit(int[] prices) {
        int i,n=prices.length;
        int min=prices[0];
        int max=0;
        for(i=1;i<n;i++)
        {
            if(min>prices[i])
                min=prices[i];
            max=Math.max(max,prices[i]-min);
        }
        return max;
        
    }
}