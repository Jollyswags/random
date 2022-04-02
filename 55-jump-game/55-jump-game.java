class Solution {
    public boolean canJump(int[] nums) {
         int n=nums.length-1;
        int i;
        int goodindex=n;
        for(i=n;i>=0;i--)
        {
            if(i+nums[i]>=goodindex)
            {
                goodindex=i;
            }
        }
        return goodindex==0;
        
    }
}