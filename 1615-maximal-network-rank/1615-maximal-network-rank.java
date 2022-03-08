class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    public int maximalNetworkRank(int n, int[][] roads) {
        int ans= Integer.MIN_VALUE;
        int degree[]=new int[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int road[] : roads)
        {
            int u = road[0];
            int v = road[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    int temp = degree[i] + degree[j];
                    if(adj.get(i).contains(j))
                    {
                        temp--;
                    }
                    ans=Math.max(ans,temp);
                }
            }
        return ans;
        
    }
}