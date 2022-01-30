class Solution {
   int[] searchRange(int[] nums, int target) {
    if(nums == null || nums.length == 0)
        return new int[]{-1,-1};
    int left = 0; 
    int right = nums.length-1;
    while(left <= right)
    {
        int mid =(left+right)/2;
        int midl = mid;
        int midr = mid;
        while(midl>=0 && nums[midl] == nums[mid])
        {
            midl--;
        }
        while( midr<=nums.length-1 && nums[midr] == nums[mid])
        {
            midr++;
        }
        if(nums[mid] == target)
        {
            int[] res = new int[2];
            res[0] = midl+1;
            res[1] = midr-1;
            return res;
        }
        else if(nums[mid] >target)
        {
             right = midl;
        }
        else 
        {
            left = midr;
        }
    }
    return new int[]{-1,-1};
}

}