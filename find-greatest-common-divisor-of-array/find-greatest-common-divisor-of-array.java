class Solution {
   public int findGCD(int[] nums) {
        int small=Integer.MAX_VALUE;
        int large=Integer.MIN_VALUE;
        
        for(int x : nums)
        {
            large=Math.max(large,x);
            small=Math.min(small,x);
        }
        
        return gcd(small,large);
            
        
    }
    
    int gcd(int num1, int num2)
    {
        if (num2%num1==0)
            return num1;
        else 
            return gcd(num2%num1,num1);
    }
}