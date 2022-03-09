class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // create graph Adj List
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge: edges) {
            adj.get(edge[1]).add(edge[0]);
        }
        // create ans list by dfs
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0; i<n; i++) {
            Set<Integer> visit = new TreeSet<>();
            dfs(i, adj, visit);
            ll.add(new ArrayList<>(visit));
        }
        return ll;
    }
    
    public void dfs(int u, List<List<Integer>> adj, Set<Integer> visit) {
        for(int v: adj.get(u)) {
            if(!visit.contains(v)){
                visit.add(v);
                dfs(v, adj, visit);
            }
        }
    }
}