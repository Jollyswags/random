class Solution {
    public int maxPower(String s) {
        int l=1,i=0,max=0;
        if(s.length()==1)
            return 1;
        while(i<s.length() && i+1 <s.length())
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                l++;
                
                
            }
            else
            {
                
                l=1;
            }
            max=Math.max(max,l);
            i++;
        }
        return max;
        
    }
}