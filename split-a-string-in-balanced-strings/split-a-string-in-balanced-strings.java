class Solution {
    public int balancedStringSplit(String s) {
        int i,count=0,c=0;
        if(s.length()==1)
            return count;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='L')
                c++;
            else
                c--;
            if(c==0)
                count++;
            
                   
            
        }
        return count;
        
        
    }
}