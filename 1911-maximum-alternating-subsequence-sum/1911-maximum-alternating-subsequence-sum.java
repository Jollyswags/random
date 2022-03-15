class Solution {

   public long maxAlternatingSum(int[] nums) {
       long p=0;
    long l=0;
    
    for(int i=0; i<nums.length;)
    {
        while(i<nums.length-1 && nums[i] < nums[i+1] )
        {
            i++;
        }
        
        p+= nums[i];
        
        int j=i+1;
        while(j<nums.length-1 && nums[j] > nums[j+1])
        {
            j++;
        }
        i=j+1;
        if(j<nums.length-1)
        {
            l+= nums[j];
        }
    }
    
    return p-l;
    }
}