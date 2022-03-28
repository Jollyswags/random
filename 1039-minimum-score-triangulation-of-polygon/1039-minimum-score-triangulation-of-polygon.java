class Solution {
    public int minScoreTriangulation(int[] arr) {
         int[][] dp = new int[arr.length][arr.length];
        for (int g = 2; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp[0].length; i++, j++) {
                 if (g == 2) {
                    dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
                }

                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k <= j - 1; k++) {
                        int leftpart = dp[i][k];
                        int rightpart = dp[k][j];
                        int triangle = arr[i] * arr[j] * arr[k];

                        int total = leftpart + rightpart + triangle;
                        min=Math.min(min,total);
                    }
                     dp[i][j] = min;
                }
            }
           
        }
        return dp[0][dp[0].length - 1];  
    }
}