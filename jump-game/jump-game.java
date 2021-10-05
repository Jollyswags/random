class Solution {
    public boolean canJump(int[] nums) {
         int n = nums.length - 1;

    int goodIndex = n;
    for (int i = n; i >= 0; i--) {
        if (i + nums[i] >= goodIndex) {
            goodIndex = i;
        }
    }
    return goodIndex == 0;  
    }
}