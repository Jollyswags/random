class Solution {
    public int maxProfit(int[] prices) {
          int n = prices.length;
    int bs=-prices[0];
    int ss=0;
    int cs=0;
    
    for(int i=1;i<n;i++){
        int b=0,s=0,c=0;
        
        b = Math.max(bs , cs-prices[i]);
        s = Math.max(ss , bs+prices[i]);
        c = Math.max(ss,cs);
        
        bs=b;
        ss=s;
        cs=c;
    }
    return ss;
    }
}