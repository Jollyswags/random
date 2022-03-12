class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        int i;
        for(i=0;i<s.length();i++)
        {
            ans+=palin(s,i,i);
            ans+=palin(s,i,i+1);
            
        }
        return ans;
        
    }
    public int palin(String s, int lo, int hi)
    {
        int ans=0;
        while(lo>=0 && hi<s.length())
        {
            if(s.charAt(lo)!=s.charAt(hi))
                break;
            lo--;
            hi++;
            ans++;
        }
        return ans;
    }
        
}