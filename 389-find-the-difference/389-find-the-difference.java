class Solution {
    public char findTheDifference(String s, String t) {
        int ans =0;
        for(int i=0;i<t.length();i++)
            ans += t.charAt(i);
        
        for(int i=0;i<s.length();i++)
            ans -= s.charAt(i);
        return (char)ans;
    }
}