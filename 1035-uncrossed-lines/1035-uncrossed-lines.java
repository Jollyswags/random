class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i,j;
        int lcs[][]=new int[m+1][n+1];
        for(i=0;i<=m;i++)
        {
            for(j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                    lcs[i][j]=0;
                else
                    if(nums1[i-1]==nums2[j-1])
                    {
                        lcs[i][j]=lcs[i-1][j-1]+1;
                    }
                else
                    lcs[i][j]=Math.max(lcs[i][j-1],lcs[i-1][j]);

            }
        }
        return lcs[m][n];
        
    }
}