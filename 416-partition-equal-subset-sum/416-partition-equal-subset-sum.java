class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum=0;
        for(int n:nums)
            totalsum+=n;
        if(totalsum%2!=0)
            return false;
        int subsetsum=totalsum/2;
        int n=nums.length;
        boolean dp[][]=new boolean[n+1][subsetsum+1];
        dp[0][0]=true;
        int i,j;
        for(i=1;i<=n;i++)
        {
            int currsum=nums[i-1];
            for(j=0;j<=subsetsum;j++)
            {
                if(j<currsum)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-currsum];
            }
        }
        return dp[n][subsetsum];
        
    }
}