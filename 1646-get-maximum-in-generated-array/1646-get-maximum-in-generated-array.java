class Solution {
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int i,max=0;
        int nums[]=new int [n+1];
        nums[0]=0;
        nums[1]=1;
        for(i=1;i<=n/2;i++)
        {
            nums[2*i]=nums[i];
            max=Math.max(max,nums[2*i]);
            if(2*i==n)
                break;
            nums[2*i + 1]=nums[i] + nums[i+1];
            max=Math.max(max,nums[2*i+1]);
        }
        return max;
        
    }
}