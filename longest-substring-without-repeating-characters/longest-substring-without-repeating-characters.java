class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        int max=0;
        int i,j,c;
        int l=s.length();
        for(i=0;i<l;i++)
        {
            HashMap<Character, Integer> map=new HashMap<>();
            map.put(s.charAt(i),1);
            c=1;
            max=Math.max(max,c);
            for(j=i+1;j<l;j++)
            {
                
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                if(map.get(s.charAt(j))>1)
                    break;
                else
                     c++;
                max=Math.max(max,c);
                
               
                
            }
        }
        return max;
        
    }
}