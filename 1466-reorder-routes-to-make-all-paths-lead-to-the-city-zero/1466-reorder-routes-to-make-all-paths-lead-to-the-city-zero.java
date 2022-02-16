class Solution {
    private static class Edge {
        int to; 
        boolean original;
        
        public Edge(int to, boolean original) {
            this.to = to;
            this.original = original;
        }
    }
    
    ArrayList<Edge>[] graph;
    int count = 0; 
    
    public int minReorder(int n, int[][] connections) {
        graph = (ArrayList<Edge>[]) new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        
        for(int[] edge : connections) {
            int from = edge[0], to = edge[1];
            graph[from].add(new Edge(to, true));
            graph[to].add(new Edge(from, false));
        }
        
        dfs(0, 0);
        return count;
    }
    
    private void dfs(int v, int p) {
        for(Edge nei : graph[v]) {
            if (nei.to == p) continue;
            if (nei.original) {
                count++;
            }
            dfs(nei.to, v);
        }
    }
}