class Solution {
    public int findMin(int[] nums) {
         int n = nums.length;
        int f = 0, l= n-1;
        int mid = f+(l-f)/2;
        while(f<l){
            if ( nums[f]<nums[l])
                return nums[f];
            if (nums[mid] == nums[f] && nums[mid] == nums[l]){
                f++;
                l--;
            }
            else if( nums[mid]<nums[f] ){
                l = mid;
            }
            else {
                f = mid+1;
            }
            mid = f+(l-f)/2;
        }
        return nums[f];
    }
}