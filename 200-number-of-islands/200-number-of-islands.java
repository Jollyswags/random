class Solution {
      public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        final UnionFind uf = new UnionFind(grid.length*grid[0].length);
        int zeros = 0;
          int m=grid.length;
          int n=grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    ++zeros;
                    continue;
                }    
                    
                if (j > 0 && grid[i][j] == '1' && grid[i][j-1] == '1')
                    uf.union(i*n+j, i*n+(j-1));
                    
               
                if (i > 0 && grid[i][j] == '1' && grid[i-1][j] == '1')
                    uf.union(i*n+j, (i-1)*n+j);
                    
            }  
        }
        return Math.abs(uf.getCount()-zeros);
    }
    
    private class UnionFind {
        private final int[] parents;
        private final int[] rank;
        private int noOfIslands;
        
        UnionFind(int n) {
            rank = new int[n]; parents = new int[n];
            noOfIslands = n;
            for (int i = 0; i < n; i++) {
                rank[i] = 1; parents[i] = i;
            }
        }
        
        void union(int p, int q) {
            final int pParent = find(p);
            final int qParent = find(q);
            
            if (pParent == qParent) return;
            
            if (rank[pParent] >= rank[qParent]) {
               rank[pParent] = (rank[qParent] == rank[pParent]) 
                   ? rank[pParent]++ : rank[pParent];
               parents[qParent] =  pParent;
            } else {
                parents[pParent] = qParent;
            }
            noOfIslands--;
        }
        
        int find(int node) {
            int parent = parents[node];
             if(node == parent) return parent; 
             parents[node] = find(parent);
            return parents[node];
        }
        
        int getCount() {
            return noOfIslands;
        }
    }
}
