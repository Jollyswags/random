class Solution {
    public int climbStairs(int n) {
        int a,b;
        a=1;
        b=2;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int i;
        for(i=3;i<=n;i++)
        {
            int sum=a+b;
            a=b;
            b=sum;
        }
        return b;
        
    }
}