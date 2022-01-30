class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for ( int i: nums ) {
            max = Math.max(max, i);
            sum += (long)i;
        }
        if ( m==nums.length ) {
            return max;
        }
        if ( m==1 ) {
            return (int)sum;
        }
        long l = (long)max;
        long r = sum;
        while ( l<=r ) {
            long mid = (l+r)/2;
            if ( check(mid, nums, m) ) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public boolean check( long mid, int[] nums, int m ) {
        int cnt = 1;
        long total = 0;
        for ( int i: nums ) {
            if ( i>mid ) {
                return false;
            }
            total += i;
            if ( total>mid ) {
                total = i;
                cnt++;
            }
        }
        return cnt<=m;
    }
}