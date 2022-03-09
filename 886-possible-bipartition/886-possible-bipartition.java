class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] a: dislikes) {
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }
        
        int[] colors = new int[N+1];
        
        for(int i = 1; i <= N; i++) { // graph can have multiple components, hence try dfs from each node
            if(colors[i] == 0) { // node is not part of 1 of the previously visited components
                colors[i] = 1; // paint red
                boolean res = dfs(graph, i, colors);
                if(!res) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(List<List<Integer>> graph, int cur, int[] colors) {
        
        for(int adj : graph.get(cur)) {
            if(colors[cur] == colors[adj]) {
                return false;
            } else if(colors[adj] == 0) {
                colors[adj] = -colors[cur]; // paint with other color than the current node
                boolean res = dfs(graph, adj, colors);
                if(!res) {
                    return false;
                }
            }
        }
        
        return true;
    }
}