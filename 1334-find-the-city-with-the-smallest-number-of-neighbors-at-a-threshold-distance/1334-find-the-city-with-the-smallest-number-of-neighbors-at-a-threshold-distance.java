class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
         int INF = (int) 1e6;
        int[][] graph = new int[n][n];
        for( int i = 0; i < n ; i++){
            Arrays.fill(graph[i],INF);
            graph[i][i]  = 0;
        }
        for( int[] edge : edges){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        
        for( int k = 0; k < n ; k++){
            for( int i = 0; i < n ; i++){
                for( int j = 0; j < n ; j++){
                    graph[i][j]  =  Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int minReachable = n, result = 0;
        for( int i = 0; i < n ; i++){
            int reachable = 0;
            for( int j = 0 ; j < n ; j++){
                if( graph[i][j] <= distanceThreshold){
                    reachable++;
                }
            }
            if( reachable <= minReachable){
                minReachable = reachable;
                result = i;
            }
        }
        return result;
    }
}