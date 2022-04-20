class Solution {    
    public boolean isMin(int[] nums, int min, int maxOperations){
        int operations = 0;
        for(int val : nums){
            if(val > min){
                operations += val/min;
                if(val%min == 0){
                    operations--;
                }
            }
        }
        return operations <= maxOperations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i], max);
        }
        int low = 1, high = max, ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(isMin(nums, mid, maxOperations)){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}