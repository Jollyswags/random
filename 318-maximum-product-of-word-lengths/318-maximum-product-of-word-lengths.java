class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
       
       for(int i=0; i<words.length; i++)
       {
           HashMap<Character, Integer> mp = new HashMap<>();
           for(char c: words[i].toCharArray())
           {
               mp.put(c, mp.getOrDefault(c, 0)+1);
           }
           
           
           for(int j=0; j<words.length && j!=i; j++)
           {
               boolean flag = false;
               for(int k=0; k<words[j].length(); k++)
               {
                   if(mp.containsKey(words[j].charAt(k)))
                   {
                       flag = true;
                   }
               }
               if(flag == false)
               {
                   max = Math.max(max, words[i].length()*words[j].length());
               }
           }
       }
       
       return max;
    }
}