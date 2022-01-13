class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<Integer> graph[]=new ArrayList[n+1];
        int i;
        for(i=0;i<=n;i++)
            graph[i]=new ArrayList<>();
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        Queue<Integer> q=new ArrayDeque<>();
        q.add(1);
        boolean visited[]=new boolean[n+1];
        double prob[]=new double[n+1];
        prob[1]=(double)1;
        visited[1]=true;
        while(q.size()!=0 && t>0)
        {
            int s=q.size();
            while(s-->0)
            {
                int node=q.remove();
                int vis=0;
                for(int nnode:graph[node])
                    if(visited[nnode]==false)
                        vis++;
                for(int nnode:graph[node])
                {
                    if(visited[nnode]==false)
                    {
                        q.add(nnode);
                        visited[nnode]=true;
                        prob[nnode]=prob[node]/(double)vis;
                        
                    }
                   
                }
                 if(vis>0)
                        prob[node]=0;
            }
            t--;
        }
        return prob[target];
    }
}