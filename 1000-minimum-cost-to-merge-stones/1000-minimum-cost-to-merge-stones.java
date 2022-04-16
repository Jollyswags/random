class Solution {
   int psum[];
    public int mergeStones(int[] nums, int k) {
        int n=nums.length;
    if ((n - 1) % (k - 1) != 0) return -1;
       psum=new int[n];
        
        psum[0]=nums[0];
        
        for(int i=1;i<n;i++)
            psum[i]=psum[i-1]+nums[i];
        
        int dp [] []=new int[n][n];
        
        for(int len=k;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int z=i;z<j;z+=k-1){
                   dp[i][j] = Math.min(dp[i][j], dp[i][z] + dp[z+1][j]);}
                   
                   if ((len-1)%(k-1) == 0)
                    dp[i][j] += psum[j]-(i>0?psum[i-1]:0); 
                    
                
            }
        }
        return dp[0][n-1];
    }
}