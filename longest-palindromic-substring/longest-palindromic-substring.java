class Solution {
    String str="";
    public String longestPalindrome(String s) {
         int ans=0;
        int i;
        for(i=0;i<s.length();i++)
        {
            ans+=palin(s,i,i);
            ans+=palin(s,i,i+1);
            
        }
        return str;
    }
    public int palin(String s, int lo, int hi)
    {
        int ans=0;
        while(lo>=0 && hi<s.length())
        {
            if(s.charAt(lo)!=s.charAt(hi))
                break;
            String temp=s.substring(lo,hi+1);
            if(temp.length()>str.length())
                str=temp;
            lo--;
            hi++;
            ans++;
        }
        return ans;
    }
}