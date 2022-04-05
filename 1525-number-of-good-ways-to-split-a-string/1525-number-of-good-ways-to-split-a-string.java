class Solution {
    public int numSplits(String s) {
       int len=s.length();
        int i;
        Set<Character> leftl=new HashSet<>();
        Set<Character> rightl=new HashSet<>();
        int left[]=new int[len];
        int right[]=new int[len];
        for(i=0;i<len;i++)
        {
            leftl.add(s.charAt(i));
            rightl.add(s.charAt(len-1-i));
            left[i]=leftl.size();
            right[len-1-i]=rightl.size();
            
        }
        int c=0;
        for(i=1;i<len;i++)
        {
            if(left[i-1]==right[i])
                c++;
        }
        return c;
    }
}