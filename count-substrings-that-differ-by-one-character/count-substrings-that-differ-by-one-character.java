class Solution {
    public int countSubstrings(String s, String t) {
       int i,j;
        int ans=0;
        int x,y;
        int d;
        for(i=0;i<s.length();i++)
            for(j=0;j<t.length();j++)
            {
                d=0;
                x=i;
                y=j;
                while(x<s.length() && y<t.length())
                {
                    if(s.charAt(x)!=t.charAt(y))
                    {
                        d++;
                    }
                    if(d==1)
                        ans++;
                    if(d==2)
                        break;
                    x++;
                    y++;
                }
            }
        return ans;
    }
}