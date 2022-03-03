class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
          if (nums == null || nums.length < 3) return 0;
        final int N = nums.length;
        int res = 0, len = 0;
        for (int i = 2; i < N; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                len++;
                res += len;
            } else {
                len = 0;
            }
        }
        return res;
    }
}