class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
          if(firstWord.isEmpty() && secondWord.isEmpty() || targetWord.isEmpty())
            return false;   
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sbTarget = new StringBuilder();
        
        for(int i = 0; i < firstWord.length(); i++)
            sb1.append(firstWord.charAt(i) -'a');
        
         for(int i = 0; i < secondWord.length(); i++)
            sb2.append(secondWord.charAt(i) -'a');
    
        for(int i = 0; i < targetWord.length(); i++)
            sbTarget.append(targetWord.charAt(i) -'a');
        
        return Integer.parseInt(sbTarget.toString()) == (Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString()));
    }
}