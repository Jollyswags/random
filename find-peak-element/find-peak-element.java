class Solution {
    public int findPeakElement(int[] nums) {
        return bs(nums,0,nums.length-1);
    }
    int bs(int nums[], int l,int r)
    {
        
            if(l==r)
            return l;
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[mid+1])
                return bs(nums,l,mid);
            
             return bs(nums,mid+1,r);
        
    }
}