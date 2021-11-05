class Solution {
    public boolean canBeIncreasing(int[] nums) {
         boolean flag = false;
    int prev = nums[0];
    int prevPrev = 1;
    for(int i = 1; i < nums.length; i++) {
        if(nums[i] <= prev) {
            if(flag) return false;
            flag = true;
            //decide which element to remove and make the other as prev element for next iteration
            if(nums[i] > prevPrev) prev = nums[i];
        } else {
            prevPrev = prev;
            prev = nums[i];
        }
        
    }
    return true;
        
    }
}