class Solution {
    public int minimumDeletions(String s) {
          int aCount = 0;
        int bCount = 0;
        int n = s.length();
        
        for (int i = n - 1; i >= 0; i--) {            
            if (s.charAt(i) == 'b')
                bCount++;
        }
        
        if (bCount == 0 || bCount == s.length())
            return 0;
        
        int maxLen = bCount;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
            if (s.charAt(i) == 'b') {
                bCount--;
            }
            maxLen = Math.max(maxLen, aCount + bCount);
        }
        
        return s.length() - maxLen;        
    }
}