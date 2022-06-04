class Solution {
    public int minFallingPathSum(int[][] matrix) {int n = matrix.length;
        int[][] dp = new int[n][n];
        //initially filling the  last row
        for(int i=n-1;i>=0;i--)
            dp[n-1][i] = matrix[n-1][i];
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(j == 0)
                {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]);
                    dp[i][j] += matrix[i][j];
                }
                else if(j == n-1)
                {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j-1]);
                    dp[i][j] += matrix[i][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i+1][j],Math.min(dp[i+1][j-1],dp[i+1][j+1]));
                    dp[i][j] += matrix[i][j];
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            ans = Math.min(dp[0][i],ans);
        
        return ans;
        
        
    }
}