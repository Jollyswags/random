class Solution {
    public void moveZeroes(int[] nums) {
        int lastindex=0;
        int curr,temp;
        for(curr=0;curr<nums.length;curr++)
        {
           if(nums[curr]!=0) //swap
           {
               temp=nums[lastindex];
               nums[lastindex]=nums[curr];
               nums[curr]=temp;
               lastindex++;
           }
            
        }
        
        
    }
}