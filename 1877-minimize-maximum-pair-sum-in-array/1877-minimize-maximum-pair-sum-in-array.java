class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int len= nums.length;
        int r=len/2;
        int l=r-1;
        int max=Integer.MIN_VALUE;
        while(l>=0 && r<len)
        {
            int sum= nums[r]+nums[l];
            max=Math.max(sum, max);
            l--;
            r++;
        }
        return max;
        
    }
}