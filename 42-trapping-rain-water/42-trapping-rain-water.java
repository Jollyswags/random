class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=0;
        int lmax=0;
        int rmax=0;
        while(left<right)
        {
            if(height[left]<height[right])
            {
                if(lmax<=height[left])
                {
                    lmax=height[left];
                }
                else
                {
                    ans+=lmax-height[left];
                }
                left++;
            }
            else
            {
                if(rmax<=height[right])
                {
                    rmax=height[right];
                }
                else
                {
                    ans+=rmax-height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
//TC:O(N)
//O(1)