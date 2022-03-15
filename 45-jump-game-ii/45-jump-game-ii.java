class Solution {
    public int jump(int[] nums) {
        int j=0;
        int n=nums.length-1;
        if(nums.length==1)
            return 0;
        int currend=0,farthest=0;
        int i;
        for(i=0;i<n;i++)
        {
            farthest=Math.max(i+nums[i],farthest);
            if(i==currend)
            {
                j++;
                currend=farthest;
            }
            
        }
        return j;
        
    }
}