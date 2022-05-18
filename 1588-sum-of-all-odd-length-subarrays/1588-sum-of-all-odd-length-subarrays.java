class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
         int N = arr.length;
        int ans = 0;
         //create prefix sum array
        int[] prefixSum = new int[N+1];
        // fill prefix sum array as ps[i] equal sum of all elements from 0 - i-1, i <= N
        for ( int i = 0; i < arr.length; i++ )  prefixSum[i+1] += prefixSum[i] + arr[i];
        for ( int i = 0; i < N; i++ ) {
            for ( int j = i; j < N; j++ ) {
                //skip even length
                if ( ((j - i + 1)&1) == 0 )    continue;
                //append sub array length to answer
                ans += prefixSum[j+1]-prefixSum[i];
            }
        }
        return ans;
    }
}