class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int sum=0;
        for(String s: operations)
        {
            if(s.equals("++X") || s.equals("X++"))
            {
                sum+=1;
                
            }
            if(s.equals("--X") || s.equals("X--"))
            {
                sum-=1;
            }
        }
        return sum;
        
    }
}