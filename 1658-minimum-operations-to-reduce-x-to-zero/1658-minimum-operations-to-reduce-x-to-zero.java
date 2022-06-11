class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int left = 0;
        for (;left<nums.length;++left) {
            sum+=nums[left];
            if (sum>=x) break;
        }
        
        int ans = sum == x? left + 1 : Integer.MAX_VALUE;
        int right = nums.length-1;
        
        while (left < right) {
           if (sum == x) {
                int count = left + 1 + nums.length - 1 -right;
                ans = Math.min(ans, count);
            } 
            
            if (sum >= x) {
                if (left < 0) break;
                sum -= nums[left--];
            } 
            if (sum < x) {
                sum += nums[right--];
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}