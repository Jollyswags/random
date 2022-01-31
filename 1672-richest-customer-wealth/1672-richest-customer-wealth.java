class Solution {
    public int maximumWealth(int[][] accounts) {
        int m=accounts.length;
        int n=accounts[0].length;
       
        int i=0,j,max=0;
        int a[]=new int[m];
      
        while(i<m)
        {
          a[i]=0;
          for(j=0;j<n;j++)
           {
            a[i]+=accounts[i][j];
            
            }
         
            if(max<a[i])
                max=a[i];
            i++;
        }
        
        return max;
    }
}