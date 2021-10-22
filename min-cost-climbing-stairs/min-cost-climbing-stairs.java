class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int i,n=arr.length;
        int dp[]=new int[n+1];
        for(i=2;i<=n;i++)
        {
            int x=arr[i-1] + dp[i-1];
            int y=arr[i-2] + dp[i-2];
            dp[i]=Math.min(x,y);
        }
        return dp[n];
        
    }
}