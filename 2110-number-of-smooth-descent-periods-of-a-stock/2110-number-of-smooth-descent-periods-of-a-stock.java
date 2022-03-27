class Solution {
    public long getDescentPeriods(int[] arr) {
         int n=arr.length;
    int dp[] = new int[n];
    long res=0;
    for(int i=1;i<n;i++)
    {
        dp[i]=(arr[i-1]-arr[i]==1)?dp[i-1]+1 : 0;
        res+=dp[i];
    }
    return res+n;
    }
}