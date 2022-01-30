class Solution {
    
    // Our approach will be to find that particular difference which has atmost
    // k pairs by Binary-Search
    public int smallestDistancePair(int[] nums, int k) {
        
        //Sort the array
        Arrays.sort(nums);
        int length = nums.length;
        
        //This can be the maximum difference in our given array
        int maxDiff = nums[length - 1] - nums[0];
        
        int start = 0;
        int end = maxDiff;
        
        while(start < end){
            
            int mid = start + (end - start)/2;
            
            if(isPair(nums,mid,k))
                end = mid;
            
            else
                start = mid+1;
        }
        
        return start;
    }
    
   
    public boolean isPair(int[] nums, int mid, int k){
        
        int count = 0;
        int i = 0;
        for(int j = 1; j<nums.length; j++){
            
            while(nums[j] - nums[i] > mid)
                i++;
            count += j-i;
        }
        return (count >= k);
    }
    
    
}