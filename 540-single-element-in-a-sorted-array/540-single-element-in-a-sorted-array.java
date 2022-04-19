class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        
        int lo = 0,hi = nums.length-1;
        while(lo<=hi){
            int mid = lo +(hi-lo)/2;
            
            
            //means mid is second element of the pair
            if(mid-1>=0 &&(nums[mid]==nums[mid-1])){ 
                //check if mid is at odd pos
                if((mid&1)==1){
                    lo = mid+1;
                }else{
                    hi = mid;
                }
                
            }else if(mid+1<nums.length &&(nums[mid]==nums[mid+1])){ //means mid is first element of the pair
                //check if mid is at even pos
                if((mid&1)==0){
                    lo = mid+2;
                }else{
                    hi = mid;
                }
                
            }else{ //means mid is single
                return nums[mid];
            }
        }
        return -1;
    }
}