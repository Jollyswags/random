class Solution {
    public int minMoves(int[] nums) {
          int min=nums[0];
        int target=nums[0];
        int res=0;
        for(int n:nums){
            min=Math.min(min,n);
            res+=n-target;
        }
        res+=nums.length*(target-min);
        return res;
    }
}