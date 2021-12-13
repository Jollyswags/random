class Solution {
    public boolean repeatedSubstringPattern(String str) {
         int n = str.length();
        String pattern = str.substring(1) + str.substring(0,n-1);
        return pattern.contains(str);
        
    }
}