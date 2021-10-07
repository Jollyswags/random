class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[1] - b[1]);
        int curr=Integer.MIN_VALUE;
        int ans=0;
        for(int pair[]: pairs )
            if(curr<pair[0])
            {
                curr=pair[1];
                ans++;
            }
        return ans;
    }
}
        
        
        
        
        
        
    
/*Time Complexity: O(NlogN) where Nis the length of S. The complexity comes from the sorting step, but the rest of the solution does linear work.

Space Complexity: O(N). The additional space complexity of storing cur and ans, but sorting uses O(N) space. Depending on the implementation of the language used, sorting can sometimes use less space.*/