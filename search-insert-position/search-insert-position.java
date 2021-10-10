class Solution {
    public int searchInsert(int[] nums, int target) {
        int r=bs(nums,target,0,nums.length-1);
        return r;
        
    }
    int bs(int arr[],int target,int low,int high)
    {
        while(low<=high)
        {
        int mid=(low+high)/2;
        if(arr[mid]==target)
            return mid;
        if(arr[mid]<target)
            low=mid+1;
        if(arr[mid]>target)
            high=mid-1;
        }
        return low;
    }
}