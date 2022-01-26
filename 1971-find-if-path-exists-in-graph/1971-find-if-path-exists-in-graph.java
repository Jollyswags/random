class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        int k=0;
        int len=edges.length;
       // System.out.println(len);
        for(int edge[] : edges)
        {
            int u=edge[0];
            int v=edge[1];
            if(!map.containsKey(u))
                map.put(u,new ArrayList<>());
            map.get(u).add(v);
            if(!map.containsKey(v))
                map.put(v,new ArrayList<>());
            map.get(v).add(u);
            
        }
        Stack<Integer> q=new Stack();
        HashSet<Integer> vis=new HashSet<>();
        //set.add(start);
        q.push(source);
        while(!q.isEmpty())
        {
            int u=q.pop();
            vis.add(u);
            if(u==dest)
                return true;
            for(int v:map.get(u))
            {
               if(!vis.contains(v))
                q.push(v);
            }
        }
        return false;
    }
    // bfs
}