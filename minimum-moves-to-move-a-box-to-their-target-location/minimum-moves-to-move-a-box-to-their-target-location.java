class Solution {
   int[][] dir ={{-1,0},{1,0},{0,1},{0,-1}};
    public int minPushBox(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        int bx=-1, by=-1, px=-1, py=0, tx=-1, ty=-1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='B'){
                    bx=i;
                    by=j;
                }
                if(grid[i][j]=='T'){
                    tx=i;
                    ty=j;
                }
                if(grid[i][j]=='S'){
                    px=i;
                    py=j;
                }
            }
        }

        //记录移动到当前状态需要推动盒子的步骤
        int[][][][] memo = new int[m][n][m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        memo[bx][by][px][py] = 0;

        //双端队列做BFS
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{bx, by, px, py});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            //推到了最终位置
            if(cur[0]==tx && cur[1]==ty){
                return memo[cur[0]][cur[1]][cur[2]][cur[3]];
            }

            //人在动，盒子不动的情况，推动次数不变，将新的坐标加入加入队首
            for(int k=0; k<dir.length; k++){
                int npx = cur[2] + dir[k][0], npy = cur[3] + dir[k][1];
                if(npx<0 || npx>=m || npy<0 || npy>=n) continue; //越界
                if(grid[npx][npy]=='#') continue; //撞墙
                if(npx==cur[0] && npy==cur[1]) continue; //与盒子重合
                if(memo[cur[0]][cur[1]][npx][npy] >= 0) continue; //已经访问过了
                queue.addFirst(new int[]{cur[0], cur[1], npx,  npy});
                memo[cur[0]][cur[1]][npx][npy] = memo[cur[0]][cur[1]][cur[2]][cur[3]]; //推动次数不变
            }

            //人推动箱子，要求：1 任何箱子相邻 2 推动的方向不是墙
            if(Math.abs(cur[0]-cur[2]) + Math.abs(cur[1]-cur[3])==1){ //相邻
                //找到推动的方向,人按照某个方向移动之后，就是box,则当前方向就是要找的方向
                for(int k=0; k<dir.length; k++){
                    int npx = cur[2] + dir[k][0], npy = cur[3] + dir[k][1];
                    if(npx==cur[0] && npy==cur[1]){ //当前k指向的方向就是要找的方向
                        //判断box是否能朝这个方向移动
                        int nbx = cur[0] + dir[k][0], nby = cur[1] + dir[k][1];
                        if(nbx<0 || nbx>=m || nby<0 || nby>=n) continue;
                        if(grid[nbx][nby] == '#') continue;//墙
                        if(memo[nbx][nby][cur[2]][cur[3]] >= 0) continue; //已经访问过了
                        queue.addLast(new int[]{nbx, nby, cur[2],  cur[3]});
                        memo[nbx][nby][cur[2]][cur[3]] = memo[cur[0]][cur[1]][cur[2]][cur[3]]+1; //推动次数加一
                    }
                }
            }
        }
        return -1;
    }
}