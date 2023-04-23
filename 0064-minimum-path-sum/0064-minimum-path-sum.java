class Solution {
    public int minPathSum(int[][] grid) {
        int i,j;
        int m=grid.length;
        int n=grid[0].length;
        for(i=m-1;i>=0;i--)
        {
            for(j=n-1;j>=0;j--)
            {
                if(i==m-1 && j!=n-1)
                    grid[i][j]=grid[i][j]+grid[i][j+1];
                 if(i!=m-1 &&j==n-1)
                    grid[i][j]=grid[i][j]+grid[i+1][j];
                 if(i!=m-1 &&j!=n-1)
                    grid[i][j]=grid[i][j]+Math.min(grid[i][j+1],grid[i+1][j]);
            }
        }
        return grid[0][0];
        
    }
}