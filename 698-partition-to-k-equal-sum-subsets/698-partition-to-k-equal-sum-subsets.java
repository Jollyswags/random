class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) 
     {
        int n=nums.length,sum=0,max=0;
        for(int ele:nums)
        {
            sum+=ele;
            max=Math.max(max,ele);
        }
        boolean[] vis=new boolean[n];
        if(sum%k!=0||max>sum/k)
            return false;
        return canPart(nums,0,k,0,sum/k,vis);
    }
    public boolean canPart(int[] nums,int idx,int k,int sumSF,int tar,boolean []vis)
    {
        if(k==0)return true;
        if(sumSF>tar)return false;
        if(tar==sumSF)
            return canPart(nums,0,k-1,0,tar,vis);
        boolean res=false;
        for(int i=idx;i<nums.length;i++)
        {
            if(vis[i])
                continue;
            vis[i]=true;
            res=res||canPart(nums,i+1,k,sumSF+nums[i],tar,vis);
            vis[i]=false;
        }
        return res;
    }   
}