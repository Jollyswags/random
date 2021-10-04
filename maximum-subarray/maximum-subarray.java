class Solution {
    public int maxSubArray(int[] nums) {
        int prefix=0,maxsum=Integer.MIN_VALUE;
        int i;
        for(i=0;i<nums.length;i++)
        {
            prefix=nums[i]+ Math.max(prefix,0);
            maxsum=Math.max(prefix,maxsum);
        }
        return maxsum;
    }
}
//o(n)
//sc o(1)