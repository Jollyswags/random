class Solution {
    public int shortestPath(int[][] grid, int k) {
              //visited array, will keep the best remaining obstacle until given i&j
        //fill the visited array with -1, default value
        int[][] visited = new int[grid.length][grid[0].length];
        for(int[] row: visited) Arrays.fill(row, -1);
        
        //start from 0,0 and remaining obstacle k
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,k});
        
        //answer to return
        int minDistance = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                size--;
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1], obs = curr[2];
                
                //out of boundary check
                if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) continue;
                
                //if we already visited this i&j and the current remaining obstacle is less than that, we skip
				//meaning we will always keep the best remaining obstacle for the i&j
                if(obs <= visited[i][j]) continue;
                
                //updating the best remaining obstacle until this point
                visited[i][j] = obs;
                
                //found the answer
                if(i == grid.length - 1 && j == grid[0].length - 1) return minDistance;
                
                //if we hit obstacle, calc the new remaining obstacle
                if(grid[i][j] == 1) obs--;
                
                //if the remaining obstacle is less than 0, we skip
                if(obs < 0) continue;
                
                //offering the next possible moves to the queue with the new remaining obstacle
                queue.offer(new int[]{i + 1, j, obs});
                queue.offer(new int[]{i - 1, j, obs});
                queue.offer(new int[]{i, j - 1, obs});
                queue.offer(new int[]{i, j + 1, obs});
            }
            minDistance++;
        }
        
        return -1;
    }
}