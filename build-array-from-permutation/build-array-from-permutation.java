class Solution {
    public int[] buildArray(int[] nums) {
        int ans[]=new int[nums.length];
        int i;
        for(i=0;i<nums.length;i++)
        {
            ans[i]=nums[nums[i]];
        }
        return ans;
    }
}