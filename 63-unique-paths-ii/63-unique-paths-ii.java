class Solution {
    public int uniquePathsWithObstacles(int[][] path) {
         int M = path.length;
        int N = path[0].length;
        int[][] grid = new int[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(path[i][j]==1){
                    continue;
                }
                if(i==0 && j==0){
                    grid[i][j]=1;
                } else{
                    grid[i][j] = grid[i-1 >0 ? i-1 : 0][j]+grid[i][j-1>0 ? j-1: 0];
                }
            }
        }
        return grid[M-1][N-1];
    }
}