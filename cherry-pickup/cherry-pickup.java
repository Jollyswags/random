class Solution {
    int n;
    int[][][][] dp;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new int[n][n][n][n];
        int ans = recursion(0,0,0,0,grid);
        return ans <0 ? 0 : ans;
    }
    int recursion(int r1,int c1,int r2,int c2,int[][] grid)
    {
        if(r1>=n||c1>=n||r2>=n||c2>=n||grid[r1][c1] == -1|| grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if(r1 == n-1 && c1 == n-1)
            return grid[r1][c1];
        if(dp[r1][c1][r2][c2] != 0)
            return dp[r1][c1][r2][c2];
        int cherries = 0;
        if(r1 == r2 && c1 == c2)
            cherries += grid[r1][c1];
        else    cherries += grid[r1][c1] + grid[r2][c2];
        
        int f1 = recursion(r1,c1+1,r2,c2+1,grid); // hh
        int f2 = recursion(r1+1,c1,r2+1,c2,grid); // vv
        int f3 = recursion(r1,c1+1,r2+1,c2,grid); // hv
        int f4 = recursion(r1+1,c1,r2,c2+1,grid); // vh
        
        cherries += Math.max(Math.max(f1,f2),Math.max(f3,f4));
        return dp[r1][c1][r2][c2] = cherries;
    }
}