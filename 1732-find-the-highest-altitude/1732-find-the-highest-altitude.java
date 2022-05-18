class Solution {
    public int largestAltitude(int[] gain) {
        int[] a = new int[gain.length + 1];
        a[0] = 0;
        int j = 1;
        int max = a[0];
        
        for(int i = 0; i < gain.length; i++) {
            a[j] = a[j - 1] + gain[i];
            max = Math.max(a[j],max);
            j++;
        }
        
        return max;
    }
}