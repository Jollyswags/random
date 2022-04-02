class Solution {
    public int minSumOfLengths(int[] arr, int target) {
         int[] minsFound = new int[arr.length + 1];
        minsFound[0] = 2 * arr.length;
        int minLen = 2 * arr.length;
        int twoMinLens = 2 * arr.length;
        int sum = 0;
        int b = 0;
        int e = 0;
        while (b < arr.length) {
            if (sum == target) {
                minLen = Math.min(e - b, minLen);
                twoMinLens = Math.min(twoMinLens, e - b + minsFound[b]);
            }
            if (sum >= target || e == arr.length) {
                sum -= arr[b];
                b++;
            } else {
                minsFound[e] = minLen;
                sum += arr[e];
                e++;
            }
        }
        return twoMinLens < 2 * arr.length ? twoMinLens : -1;
    }
}