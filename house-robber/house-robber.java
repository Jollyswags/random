class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int robnextone=0,robnext=nums[n-1];
        int i,current;
        for(i=n-2;i>=0;i--)
        {
            current=Math.max(robnext,robnextone+nums[i]);
            robnextone=robnext;
            robnext=current;
        }
        return robnext;
        
    }
}