class Solution {
    public int maxSubArray(int[] nums) {
         int currsub=nums[0];
        int maxsum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            currsub=Math.max(currsub+nums[i],nums[i]);
            maxsum=Math.max(maxsum,currsub);
        }
        return maxsum;
    }
}