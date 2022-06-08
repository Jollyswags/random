class Solution {
    public int minFlips(String s) {
         int n=s.length(); 
    s=s+s;
    char t[]=s.toCharArray();
    char  a[]=new char[n+n];
    char b[]=new char[n+n];
    for(int i=0;i<n+n;i++)
    {
        if(i%2==0)
        {
            a[i]='1';
            b[i]='0';
        }
        else
        {
            a[i]='0';
            b[i]='1';
        }
    }
    int f=0,sec=0,ans=Integer.MAX_VALUE;
    for(int i=0;i<n+n;i++)
    {
        if(a[i]!=t[i])
            f++;
        if(b[i]!=t[i])
            sec++;
        if(i>=n)
        {
            if(a[i-n]!=t[i-n])
                f--;
            if(b[i-n]!=t[i-n])
                sec--;
        }
        if(i>=n-1)
            ans=Math.min(ans,Math.min(f,sec));
            
    }
    return ans;
    }
}