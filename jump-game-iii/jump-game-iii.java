class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean visited[]=new boolean[n];
        return dfs(arr,start,visited);
        
    }
    public boolean  dfs(int arr[], int start, boolean visited[])
    {
        if(start<0 || start>=arr.length || visited[start])
        {
            return false;
        }
        if(arr[start]==0)
            return true;
        visited[start]=true;
        return dfs(arr,start+arr[start], visited) || dfs(arr,start-arr[start], visited);
    }
}