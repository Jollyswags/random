class Solution {
    public int kthFactor(int n, int k) {
       if(k == 1)
            return 1;
        
        int s = (int)(Math.sqrt((double)(n)));
        
        for(int i = 1; i <= s; ++i)
        {
            if(n % i == 0)
            {
                if(--k == 0)
                    return i;
            }
        }
        
        for(int i = s; i >= 1; --i)
        {
            if(n % i == 0)
            {
                if(i * i == n)
                    continue;
                if(--k == 0)
                    return n / i;
            }
        }
        
        return -1;  
    }
}