class Solution {
    public void dfs(int graph[][],int src,int dest,List<List<Integer>>Olist, List<Integer>list,boolean visited[]){
        if(src==dest){
            list.add(src);
            Olist.add(new ArrayList<Integer>(list));
            list.remove(new Integer(src));
            return;
        }
        visited[src]=true;
        list.add(src);
        for(int i:graph[src]){
            if(!visited[i]){
               dfs(graph,i,dest,Olist,list,visited);
            }
        }
        visited[src]=false;
        list.remove(new Integer(src));
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len=graph.length-1;
        List<List<Integer>>Olist=new ArrayList<>();
        boolean visited[]=new boolean[len+1];
        dfs(graph,0,len,Olist, new ArrayList<>(),visited);
        return Olist;
    }
}