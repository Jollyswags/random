class Solution {
    int N = 55*55;
    int[] sz = new int[N];
    int[] f = new int[N] ;
    public int find(int x){
        if(f[x] ==x) return x;
        return f[x]= find(f[x]);
    }
     public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        for(int i = 0 ; i<m*n;i++)
        {f[i] = i ;
         sz[i]=1;
         }
         for(int i =0; i<n;i++){
            for(int j = 0;j<m;j++ ){
                if(grid[i][j]==0) continue;
                for(int d = 0; d<4;d++){
                    int tx = i+dx[d];
                    int ty = j + dy[d];
                    if(tx<0||ty<0||tx>=n||ty>=m) continue;
                    if(grid[tx][ty]==0) continue;
                    int pa = find(tx*m+ty);
                    int pb = find(i*m+j);
                    if(pa!=pb){
                        sz[pb]+=sz[pa];
                        f[pa] = pb; 
                    }
                }
            }
        }
         int res = 0;
         for(int i = 0; i<m*n;i++){
             if(grid[i / m][i % m] == 1) res = Math.max(res, sz[find(i)]);
         }
         return res;
    }
}