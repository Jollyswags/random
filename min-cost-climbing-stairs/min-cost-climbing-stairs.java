class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+1];
        int i;
        for(i=2;i<=n;i++)
        {
            int x=dp[i-1]+cost[i-1];
            int y=dp[i-2]+cost[i-2];
            dp[i]=Math.min(x,y);
        }
        return dp[n];
    }
}