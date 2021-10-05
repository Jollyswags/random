class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
       if(str2.length()<str1.length())
       {
           String temp=str1;
           str1=str2;
           str2=temp;
       }
        int prev[]=new int[str1.length()+1];
        int cur[]=new int[str2.length()+1];
        int row,col;
        for(col=str2.length()-1;col>=0;col--)
        {
            for(row=str1.length()-1;row>=0;row--)
            {
                if(str1.charAt(row)==str2.charAt(col))
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