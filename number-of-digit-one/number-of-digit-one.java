class Solution {
    public int countDigitOne(int n) {
        int dp[] = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=10;i++){
            int repeat = (int)Math.pow(10 , i-1);
            for(int j=0;j<=9;j++){
                int extra = (j == 1) ? repeat : 0;
                dp[i] += (extra + dp[i-1]);
            }
        }
        int ans = 0;
        String num = Integer.toString(n);
        int len = num.length();
        int extra = 0;
        
        for(int i=0;i<num.length();i++){
            int x = num.charAt(i) - '0';
            int now = (int)Math.pow(10 , len - i-1);
            for(int j=0;j<x;j++){
                ans += ((j == 1) ? now : 0) + dp[len-i-1] + extra * now;
            }
            if(x == 1)
                extra++;
        }
        
        ans += extra;
        return ans;
    }
}