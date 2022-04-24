class Solution {
    public int hIndex(int[] c) {
        Arrays.sort(c);
        int i = 1;

        while (i<= c.length) {
            if (c[c.length -i] < i) {
                break;
            }
            i++;
        }
        return i-1;
    }
}
//nlogn
//1