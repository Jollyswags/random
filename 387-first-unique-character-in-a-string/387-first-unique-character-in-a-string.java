class Solution {
    public int firstUniqChar(String s) {
        int vis[] = new int[26];
        for(int i=0;i<26;i++)
            vis[i]= -2;
        for(int i=0; i<s.length(); i++)
        {
            int x= s.charAt(i)-'a';
            if(vis[x]==-2)
            {
                vis[x]=i;
            }
            else
            {
                vis[x] = -1;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0 ; i<26; i++)
        {
            if(vis[i]>=0)
                ans= Math.min(ans,vis[i]);
            
        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}