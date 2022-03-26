class Solution {
    public int stoneGameVII(int[] stones) {
         int[][] dp = new int[stones.length][stones.length];
        int[] pre = new int[stones.length];
        pre[0] = stones[0];
        for(int i = 1; i < pre.length; i++)
            pre[i] = pre[i - 1] + stones[i];
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp.length; i++, j++){
                if(g == 0)
                    dp[i][j] = 0;
                else if(g == 1)    
                    dp[i][j] = Math.max(stones[i], stones[j]);
                else
                    dp[i][j] = Math.max((pre[j] - pre[i] - dp[i + 1][j]), (pre[j-1] - (i == 0 ? 0 : pre[i-1]) - dp[i][j - 1]));
            }
        }
        return dp[0][stones.length - 1];
    }
}