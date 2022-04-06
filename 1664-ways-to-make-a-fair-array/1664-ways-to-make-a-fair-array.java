class Solution {
    public int waysToMakeFair(int[] nums) {
        int count =0;
        int evenleft=0;
        int evenright=0;
        int oddleft=0;
        int oddright=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
                evenright+=nums[i];
            else
                oddright+=nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(i>0)
            {
                if(i%2==0)
                    oddleft+=nums[i-1];
                else
                    evenleft+=nums[i-1];
            }
            if(i%2==0)
            {
                evenright-=nums[i];
            }
            else
            {
                oddright-=nums[i];
            }
            if(oddleft+evenright==evenleft+oddright)
                count++;
        }
        return count;
        
    }
}