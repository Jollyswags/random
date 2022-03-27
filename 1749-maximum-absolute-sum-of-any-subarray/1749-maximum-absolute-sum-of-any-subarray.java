class Solution {
    public int maxAbsoluteSum(int[] nums) {
         int curmin = 0, curmax = 0;
        int min = 0,max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            curmax = Math.max(nums[i] + curmax,nums[i]);
            curmin = Math.min(nums[i] + curmin,nums[i]);
            min = Math.min(min,curmin);
            max = Math.max(max,curmax);
        }
        return Math.max(Math.abs(min),Math.abs(max));
    }
}