class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        
          if(nums2.length<nums1.length)
       {
           int temp[]=nums1;
           nums1=nums2;
           nums2=temp;
       }
        int prev[]=new int[nums1.length+1];
        int cur[]=new int[nums2.length+1];
        int row,col;
        for(col=nums2.length-1;col>=0;col--)
        {
            for(row=nums1.length-1;row>=0;row--)
            {
                if(nums1[row]==nums2[col])
                {
                    cur[row]=1+prev[row+1];
                }
                else
                {
                    cur[row]=Math.max(cur[row+1],prev[row]);
                }
            }
            int temp[]=cur;
            cur=prev;
            prev=temp;
        }
        return prev[0];
        
    }
}