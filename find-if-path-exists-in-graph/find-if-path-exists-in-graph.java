class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
           List<List<Integer>> list = new ArrayList<>();        
        for (int i = 0; i < n; i++) {
          list.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> q=new Stack();
        boolean vis[]=new boolean[n];
        Arrays.fill(vis,false);
        q.push(source);
        
        while(!q.isEmpty())
        {
            int u=q.pop();
            vis[u]=true;
            if(u==dest)
                return true;
            for(int v:list.get(u))
            {
               if(vis[v]==false)
               {
                   vis[v]=true;
                   q.push(v);
               }
            }
        }
        
        
        return false;
    }
    // bfs
}