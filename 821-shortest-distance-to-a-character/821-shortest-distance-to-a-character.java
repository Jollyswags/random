class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==c)
            {
                l.add(i);
            }
                
        }
        int min,k=0;
        int ans[]=new int[s.length()];
        
        for(int i=0;i<s.length();i++)
        {
           min=Integer.MAX_VALUE; 
            for(int j:l)
            {
                if(Math.abs(i-j)<min)
                    min=Math.abs(i-j);
            }
            ans[k++]=min;
        }
        return ans;
    }
}