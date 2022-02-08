class Solution {
    
         public int numRollsToTarget(int d, int f, int target) {
	
        int[][] dp = new int[d + 1][target + 1];
        
        for(int[] ar : dp)
            Arrays.fill(ar, -1);
        
        return rec(d, f, target, dp, (int) Math.pow(10, 9) + 7);
    }
    
    int rec(int d, int f, int target, int[][] dp, int mod){
        
        if(d < 0 || target < 0)
            return 0;
        
        if(d == 0 && target == 0)
            return 1;
        
        if(dp[d][target] != -1)
            return dp[d][target];
        
        int res = 0;
        
        for(int i=1;i<=f;i++){
            res = (res + rec(d - 1, f, target - i, dp, mod)) % mod;
        }
        
        dp[d][target] = res;

        return res;
    }
    
}