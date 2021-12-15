class Solution {
   private int dfs(int[] A, int i, int d, int[] dp) {
    if(dp[i] != 0) return dp[i];
    int res = 0, L = Math.max(0, i - d), R = Math.min(A.length - 1, i + d);
    for(int j = i - 1; j >= L && A[i] > A[j]; j--) res = Math.max(res, dfs(A, j, d, dp));
    for(int j = i + 1; j <= R && A[i] > A[j]; j++) res = Math.max(res, dfs(A, j, d, dp));
    return dp[i] = 1 + res;
}
public int maxJumps(int[] arr, int d) {
    int n = arr.length, res = 0;
    int[] dp = new int[n];
    for(int i = 0; i < n; i++) res = Math.max(res, dfs(arr, i, d, dp));
    return res;
}
}