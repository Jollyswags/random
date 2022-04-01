class Solution {
    public int longestArithSeqLength(int[] A) {
         int ansMax = 0, n = A.length, was, diff;
        HashMap<Integer, Integer> tillI[] = new HashMap[n];
        // initialising HashMap for all indices
        for(int i = 0; i < n; ++i)
            tillI[i] = new HashMap<>();
        
        // iterating over all non- zero length sequence forming indices
        for(int i = 1; i < n; ++i)
            // iterating over all previous values to get all possible solutions
            for(int j = 0; j < i; ++j) {
                diff = A[i] - A[j];
                was = tillI[j].getOrDefault(diff, 1);   // what was longest till j with difference diff
                ansMax = Math.max(was + 1, ansMax);
                tillI[i].put(diff, was + 1);    // length found till i with difference diff
            }
        return ansMax;
    }
}