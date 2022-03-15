class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
          int N=arr.length;
        if(N==1) return arr[0];
        int[] dp = new int[N+1];
        
        for(int i=1;i<=N;i++){
            int currMax=0; int maxSumK=0;
            for(int sub=1;sub<=k && i-sub>=0;sub++){
                currMax=Math.max(currMax,arr[i-sub]);
                maxSumK=Math.max(maxSumK,dp[i-sub]+(currMax*sub));
            }
            dp[i]=maxSumK;
        }
        return dp[N];
    }
}