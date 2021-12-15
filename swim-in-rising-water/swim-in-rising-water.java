
class Solution {
    int directions[][]=new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
    };

    public int swimInWater(int[][] grid) {
        final int n=grid.length;
        PriorityQueue<Integer> timeQueue=new PriorityQueue();
        Set<Integer> set=new HashSet();
        for(int[] g:grid){
            for(int k:g){
                if(set.add(k)){
                    timeQueue.add(k);
                }
            }
        }

        PriorityQueue<Integer> cellPQ=new PriorityQueue<Integer>((a,b)->grid[a/n][a%n]-grid[b/n][b%n]);
        cellPQ.add(0);
        while(!timeQueue.isEmpty()){
            int time=timeQueue.poll();
            while(!cellPQ.isEmpty()){
                int t=cellPQ.peek();
                if(grid[t/n][t%n]<=time){
                    cellPQ.poll();
                    if(helper(grid,t/n,t%n,time,cellPQ)){
                        return time;
                    }
                }else{
                    break;
                }
            }
        }
        return -1;

    }

    private boolean helper(int[][] grid,int r,int c,int time,Queue<Integer> qu){
        if(grid[r][c]>time){
            qu.add(r*grid.length+c);
            return false;
        }
        if(r==grid.length-1 && c==grid.length-1){
            return true;
        }
        grid[r][c]=-1;
        for(int[] dir:directions){
            int r1=r+dir[0];
            int c1=c+dir[1];
            if(r1>=0 && c1>=0 && r1<grid.length&&c1<grid.length&&grid[r1][c1]>=0){
                if(helper(grid,r1,c1,time,qu)){
                    return true;
                }
            }
        }
        return false;
    }
}