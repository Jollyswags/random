class Solution {
    public int maxProfit(int[] prices) {
            int t1 = Integer.MAX_VALUE, 
        t2= Integer.MAX_VALUE;
    int p1 = 0,
        p2 = 0;

    for (int price : prices) {
        // the maximum profit if only one transaction is allowed
       t1=Math.min(t1,price);
        p1=Math.max(p1,price-t1);
        t2=Math.min(t2,price-p1);
        p2=Math.max(p2,price-t2);
        
    }

    return p2;
    }
}