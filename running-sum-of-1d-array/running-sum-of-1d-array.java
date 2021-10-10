class Solution {
    public int[] runningSum(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        int i;
        for(i=1;i<nums.length;i++)
            dp[i]=dp[i-1]+nums[i];
        return dp;
        
    }
}