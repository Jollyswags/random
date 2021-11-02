class Solution {
    public int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums,0,0,target);
        return ans;
        
    }
    public void calculate(int nums[], int i, int s, int S)
    {
        if(i==nums.length)
        {
             if(s==S)
                ans++;
        }
        else
        {
            calculate(nums,i + 1,s+nums[i],S);
            calculate(nums,i + 1,s-nums[i],S);
        }
    }
}