class Solution {
    public int maxProduct(int[] nums) {
        int i;
        int ans=nums[0];
        int prevmaxprod=nums[0];
        int prevminprod=nums[0];
        int currmaxprod,currminprod;
       
        for(i=1;i<nums.length;i++)
        {
            currmaxprod=Math.max(prevmaxprod*nums[i],Math.max(prevminprod*nums[i],nums[i]));
            currminprod=Math.min(prevmaxprod*nums[i],Math.min(prevminprod*nums[i],nums[i]));
            ans=Math.max(ans,currmaxprod);
            prevmaxprod=currmaxprod;
            prevminprod=currminprod;
            
        }
        return ans;
        
    }
}
//n
//1