class Solution {
    private boolean isValid(int r, int c, int R, int C) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
         if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }
        int[] dr = {-1, -1, -1, 1, 1, 1, 0, 0};
        int[] dc = {-1, 0, 1, -1, 0, 1, 1, -1};
        int R = grid.length;
        int C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean vis[][]=new boolean[R][C];
        vis[0][0]=true;
        int dist=1;
        while(!queue.isEmpty())
        {
            int s=queue.size();;
            for(int i=0;i<s;i++)
            {
                int mat[]=queue.poll();
                if(mat[0]==R-1 && mat[1]==C-1)
                    return dist;
                for(int j=0;j<8;j++)
                {
                    int x=dr[j]+mat[0];
                    int y=dc[j]+mat[1];
                    if(isValid(x,y,R,C))
                    {
                         if(vis[x][y])
                            continue;
                        if(!vis[x][y] && grid[x][y]==0)
                        {
                            vis[x][y]=true;
                             queue.offer(new int[]{x,y});
                        }
                    }
                    
                }
            }
            
            dist++;
        }
        return -1;
    }
}

//n
//n