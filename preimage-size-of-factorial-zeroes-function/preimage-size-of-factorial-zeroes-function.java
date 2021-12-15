class Solution {
    public int preimageSizeFZF(int k) {
        
        int numOfTrailingZeroesInMid = 0, low = 0, high = (int)Math.pow(10, 9), mid;
        // value of high is set to the maximum possible value of K according to the constraint given in the problem statement
        
        //apply binary search to find whether there is any number having k trailing zeroes in its factorial. If yes, return 5. If no such number exists, control will come out of the while loop and return 0.
        while(low < high)
        {
            mid = (low+high)/2;
            
            numOfTrailingZeroesInMid = trailingZeroes(mid);
            
            if(numOfTrailingZeroesInMid < k)
                low = mid + 1;
            
            else if(numOfTrailingZeroesInMid > k)
                high = mid;
            
            else    return 5; //since, for every k, where k is the number of trailing zeroes 
                            // in the factorial of a number, the number of positive integers
                            // which have k trailing zeroes in its factorial is always 5.
                            // Ex.: From 5! to 9!, each value contains only one trailing 
                            // zero. From 10! to 14!, there are 2 trailing zeroes and so on..
        }  
        
        return 0;        //since there exists some value of k such that there is no number having 
						 //k zeroes in its factorial. 
						 //ex: there is no number having 5 trailing zeroes in its factorial. 24! contains 
						 //4 trailing zeroes and 25! contains 6 trailing zeroes. 
						 //Likewise, there are many values of k such as 11, 17, 23, 29, 30 etc..
						 //Every multiple of 5 contributes 1 zero to the trailing part, every multiple of 
						 //25 contributes 2 zeroes to the trailing part, every muliple of 125 contributes 
						 //3 zeroes to the trailing part and so on.
						 // Number of trailing zeroes in the factorial of a number is equal to the number 
						 //of 5's present in the prime factorization of that number.
    }
    
    public int trailingZeroes(int n) //returns number of trailing zeroes in n!
    {
        int ans = 0;
        
        for(int i = 1; i <= n; i = i * 5)
            ans += n/i;
        
        return ans;
    }
}