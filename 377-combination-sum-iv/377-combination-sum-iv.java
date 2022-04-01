class Solution {
    public int combinationSum4(int[] nums, int target) {
         if (nums == null || nums.length == 0) return 0;
        final int N = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            for (int i = 0; i < N; i++) {
                if (t - nums[i] >= 0) {
                    dp[t] += dp[t - nums[i]];
                }
            }
        }
        return dp[target];
    }
}