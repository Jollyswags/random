class Solution {
    public int fib(int n) {
        int i;
        int dp[]=new int [2];
        dp[0]=0;
        dp[1]=1;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(i=2;i<=n;i++)
        {
            int sum=dp[0]+dp[1];
            dp[0]=dp[1];
            dp[1]=sum;
        }
        return dp[1];
        
    }
}