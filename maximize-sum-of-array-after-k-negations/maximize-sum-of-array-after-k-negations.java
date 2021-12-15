class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
          Arrays.sort(nums);
        for(int i = 0;nums[i]<0 && k>0 && i<nums.length-1 ;i++,k--){
            nums[i] = -nums[i];
        }
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            res+=nums[i];
            min = Math.min(min,nums[i]);
        }
        return res-(k%2)*2*min;
    }
}