class Solution {
    public int countBinarySubstrings(String s) {
        int i;
        int prev=0;
        int cur=1;
        int ans=0;
        for(i=1;i<s.length();i++)
        {
            if(s.charAt(i-1)!=s.charAt(i))
            {
                ans+=Math.min(prev,cur);
                prev=cur;
                cur=1;
            }
            else
            {
                cur++;
            }
        }
        return ans+Math.min(prev,cur);
        
    }
}