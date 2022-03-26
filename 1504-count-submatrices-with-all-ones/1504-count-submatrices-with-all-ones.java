class Solution {
    public int numSubmat(int[][] mat) {
          int n=mat.length;
        int m=mat[0].length;
        int[][] grid=new int[n][m]; //grid which we'll use to chk how many continuous ones are there
        //initializing grid
		for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                if(j==m-1)grid[i][j]=mat[i][j];
                else{
                    if(mat[i][j]==1){
                        grid[i][j]=grid[i][j+1]+1;
                    }else{
                        grid[i][j]=0;
                    }
                }
            }
        }
		//traverse in  mat
        int ans=0;
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                int val=grid[i][j];
                for(int k=i;k<n;k++){
                    val=Math.min(grid[k][j],val);
                    ans+=val;
                }
            }
            
        }
		//return total no of matrix
        return ans;
    }
}