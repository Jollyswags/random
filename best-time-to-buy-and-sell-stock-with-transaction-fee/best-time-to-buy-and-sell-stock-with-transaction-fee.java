class Solution {
    public int maxProfit(int[] arr, int fee) {
        int cash=0,hold=-arr[0];
        int i;
        for(i=1;i<arr.length;i++)
        {
            cash=Math.max(cash,hold+arr[i]-fee);
            hold=Math.max(hold,cash-arr[i]);
        }
        return cash;
    }
}