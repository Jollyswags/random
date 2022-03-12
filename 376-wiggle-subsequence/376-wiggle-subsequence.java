class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n<2)
            return n;
        int i,up=1,down=1;
        for(i=1;i<n;i++)
        {
            if(nums[i]>nums[i-1])
                up=down+1;
            else
                if(nums[i]<nums[i-1])
                    down=up+1;
        }
        return Math.max(up,down);
        
     
        
    }
}