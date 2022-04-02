class Solution {
    public int maxResult(int[] nums, int k) {
         int n = nums.length;
        int dp[] = new int[n];
        
        dp[0] = nums[0];  
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int a[], int b[]) -> b[0] - a[0]); //max result
        pq.add(new int[]{nums[0], 0});           
        for (int i=1; i<n; i++) {                  
            
            while (!pq.isEmpty() && pq.peek()[1] < i-k) {
                pq.remove();  
            }           
        
            dp[i] = nums[i] + pq.peek()[0];
            
          
            pq.add(new int[]{dp[i], i});
            
        }
        
         return dp[n-1];
    }
}