class Solution {
    public int rob(int[] nums) {
        int i,n=nums.length;
        int maxprofit[]=new int[n+1];
        maxprofit[n]=0;
        maxprofit[n-1]=nums[n-1];
        for(i=n-2;i>=0;i--)
            maxprofit[i]=Math.max(maxprofit[i+1],maxprofit[i+2]+nums[i]);
        return maxprofit[0];
    }
}