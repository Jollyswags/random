class Solution {
  int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList();
        int maxDistance = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int i = node[0];
            int j = node[1];
            int dis = node[2];
            if (grid[i][j] == 0) maxDistance = Math.max(maxDistance, dis);
            for (int[] dir: dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && ni < grid.length && 
                    nj >= 0 && nj < grid[0].length &&
                    !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    if (grid[ni][nj] == 1) q.offer(new int[]{ni, nj, 0});
                    else q.offer(new int[]{ni, nj, dis + 1});
                }
            }
        }
        
        return (maxDistance == 0) ? -1 : maxDistance;
    }
}
//n*n
//n