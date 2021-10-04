class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[3];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int i,sum;
        for(i=3;i<=n;i++)
        {
            sum=dp[1]+dp[2];
            dp[0]=dp[1];
            dp[1]=dp[2];
            dp[2]=sum;
        }
        return dp[2];
    }
}