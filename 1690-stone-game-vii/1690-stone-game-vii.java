class Solution {
   private int[] preSum;
    private int[] dp;
    
    public int stoneGameVII(int[] stones) {
        int size = stones.length;
        preSum = new int[size + 1];
        dp = new int[size + 1];
        
        for(int i = 0; i < size; i++)
            preSum[i + 1] = preSum[i] + stones[i];
        
        for(int end = 1; end <= size; end++) {
            for(int i = 0; i < size - end; i++) {
                dp[i] = Math.max(
                    getScore(i + 1, i + end) - dp[i + 1], // As if we pick i, we need to find solution of (i+1, end).
                    getScore(i, i + end - 1) - dp[i] // As if we pick end, we need to find solution of (i, end - 1)
                ); 
            }
        }
        
        return dp[0];
    }
    
    private int getScore(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}