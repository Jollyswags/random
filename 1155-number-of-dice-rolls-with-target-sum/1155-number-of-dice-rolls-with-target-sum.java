class Solution {
  private static final int MODULO = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[n][0] = 1;
        
        for(int i = n - 1; i >= 0; --i) {
            for(int remain = target; remain > 0; --remain) {
                int ans = 0;
                for(int num = 1; num <= k; ++num) {
                    if(remain - num >= 0) {
                        ans += dp[i + 1][remain - num];
                        ans %= MODULO;
                    }
                }
                dp[i][remain] = ans;
            }
        }
        
        return dp[0][target];
    }
}