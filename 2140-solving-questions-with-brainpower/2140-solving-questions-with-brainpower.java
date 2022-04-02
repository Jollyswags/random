class Solution {
    public long mostPoints(int[][] questions) {
         long[] dp = new long[200001];
        
        for(int i = questions.length - 1; i >= 0; i--){
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[i + 1 + questions[i][1]]);
        }
        
        return dp[0];
    }
}