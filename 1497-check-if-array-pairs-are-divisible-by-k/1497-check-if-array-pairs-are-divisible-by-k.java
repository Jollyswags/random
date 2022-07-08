class Solution {
    public boolean canArrange(int[] arr, int k) {
         int cnt[]=new int[k];
        for(int i=0;i<arr.length;i++){
            int m=(arr[i]%k+k)%k;
            cnt[m]++;
        }
        for(int i=1;i<=k/2;i++){
            if(i==k-i&&cnt[i]%2==1)return false;
            if(cnt[i]!=cnt[k-i])return false;
        }
        return true;
    }
}