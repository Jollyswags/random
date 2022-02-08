class Solution {
    public int minFallingPathSum(int[][] matrix) {
           int rows = matrix.length, cols = matrix[0].length, ans = Integer.MAX_VALUE;
        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int top = matrix[i-1][j];
                int left = matrix[i-1][Math.max(0, j-1)];
                int right = matrix[i-1][Math.min(j+1, cols-1)];
                matrix[i][j] = matrix[i][j] + Math.min(top, Math.min(left, right));
            }
        }
        for(int i = 0; i < cols; i++)
            ans = Math.min(ans, matrix[rows-1][i]);
        return ans;
    }
}