class Solution {
      
    int maxSum=0;
    int dirx[]={1,0,-1,0};
    int diry[]={0,1,0,-1};
    
    public int getMaximumGold(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            
            for(int j=0;j<grid[i].length;j++){
                
                if(grid[i][j] !=0){
                    find(grid,grid.length,grid[0].length,i,j,grid[i][j]);
                }
            }
        }
        
        return maxSum;
    }
    
    public void find(int grid[][],int rowlen,int collen,int x,int y,
                    int sum){
        
        if(sum>maxSum){
            maxSum=sum;
        }
        int temp = grid[x][y];
        grid[x][y]=0;
        for(int i=0;i<4;i++){
            
            int newx=x+dirx[i];
            int newy=y+diry[i];
            if(newx>=0 && newy>=0 && newx<rowlen && newy<collen && grid[newx][newy]!=0
             ){
                find(grid,rowlen,collen,newx,newy,sum+grid[newx][newy]);
            }
        }
        grid[x][y]=temp;
    }
}