class Solution {
    
    static final int INF = (int)1e4;
    
    public int minStickers(String[] stickers, String target) {
        
        int dp[] = new int[(1 << target.length()) + 1];
        Arrays.fill(dp, -1);
        
        int ans = solve(stickers, target, 0, dp);
        
        return ans == INF ? - 1: ans;   
    }
    
    int solve(String[] stickers, String target, int mask, int dp[]) {
        int n = target.length();
        
        if(mask == ((1 << n) - 1)) {
            return 0;
        }
        
        if(dp[mask] != -1) {
            return dp[mask];
        }
        
        int ans = INF;
        
        for(int pos = 0; pos < stickers.length; pos++) {
            
            int newMask = mask;
            
            int f [] = new int[26];
            for(char c: stickers[pos].toCharArray()) f[c - 'a']++;
            
            for(int k = 0; k < n ; k++)
                if((newMask & (1 << k)) == 0 && f[target.charAt(k) - 'a'] > 0) {
                    newMask |= (1<< k);
                    f[target.charAt(k) - 'a']--;
                }

            if(newMask != mask) {
                ans = Math.min(ans, solve(stickers, target, newMask, dp) + 1);
            }
            
        }
        
        return dp[mask] = ans;
    }
    
}