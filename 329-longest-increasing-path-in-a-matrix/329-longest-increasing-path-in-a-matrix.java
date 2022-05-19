class Solution {
    static int dir[][]= {{0,-1},{-1,0},{0,1},{1,0}};
   static int dfs(int i,int j ,int m[][],int dp[][],int prev) {
		if(i<0||j<0||i>=m.length||j>=m[0].length||m[i][j]<=prev) {
			return 0;
		}
		if(dp[i][j]!=0)return dp[i][j];
		int max=0;
		for(int d[]:dir) {
			int xi=i+d[0];
			int yi=j+d[1];
			max=Math.max(max,dfs(xi,yi,m,dp,m[i][j]));
		}
        if(max==0)dp[i][j]=1;
        else
		dp[i][j]=max+1;
		return dp[i][j];
	}
    public int longestIncreasingPath(int[][] matrix) {
              int ans=0;
       int dp[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
        	   ans=Math.max(ans,dfs(i,j,matrix,dp,Integer.MIN_VALUE));
           }
       }
        return ans;
   
    }
}