class Solution {
    public int change(int amount, int[] coins) {
          int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
    }
}
/*Complexity Analysis

Time complexity: O(N×amount), where N is a length of coins array.

Space complexity: O(amount) to keep dp array.

Report Article Issue*/