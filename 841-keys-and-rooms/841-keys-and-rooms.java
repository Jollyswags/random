class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //dfs
        int n=rooms.size();
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        boolean vis[]=new boolean[n];
        vis[0]=true;
        while(!stack.isEmpty())
        {
            int node=stack.pop();
            for(int child: rooms.get(node))
            {
               if(!vis[child])
               {
                    vis[child]=true;
                    stack.push(child);
               }
            }
        }
        for(int i=0;i<n;i++)
            if(vis[i]==false)
                return false;
        return true;
    }
}