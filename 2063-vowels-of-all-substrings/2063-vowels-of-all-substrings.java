class Solution {
    public long countVowels(String word) {
         
      char[] c = word.toCharArray();
      //Set to store all the vowels 
      Set<Character> set = new HashSet<Character>(Arrays.asList('a','e','i','o','u')); 
        
      //1D dp array
      long[] array = new long[c.length];
        
      if(set.contains(c[0])) array[0] = 1;
      for(int i = 1; i < c.length; i++){
          if(set.contains(c[i])){
              array[i] = array[i-1] + (array[i-1] - ((i-2) < 0 ? 0 : array[i-2])) + i + 1;
          }
          else
              array[i] = array[i-1] + (array[i-1] - ((i-2) < 0 ? 0 : array[i-2]));
      }  
        
     return array[array.length-1];   
    }
}