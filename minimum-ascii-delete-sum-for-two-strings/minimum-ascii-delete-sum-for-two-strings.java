class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int i,j;
        int m=s1.length();
        int n=s2.length();
        int lcs[][]=new int[m+1][n+1];
        for(i=0;i<=m;i++)
        {
            for(j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                    lcs[i][j]=0;
                else
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        lcs[i][j]=lcs[i-1][j-1]+s1.codePointAt(i-1)+s2.codePointAt(j-1);
                else
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        int l=0;
        for(i=0;i<m;i++)
        {
            l+=s1.codePointAt(i);
        }
        for(j=0;j<n;j++)
        {
            l+=s2.codePointAt(j);
        }
        return l-lcs[m][n];
        
    }
}