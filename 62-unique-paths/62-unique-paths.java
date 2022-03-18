class Solution {
    public int uniquePaths(int m, int n) {
         int[][] grid = new int[m][n];
        
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(j != 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j] + grid[i][j - 1];
                }
                else {
                    grid[i][j] = 1;
                }
            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
}