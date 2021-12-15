class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int length = wordlist.length;
        for (int i = 0; i < 10; i++) {            
            int index = length/2;            
            String selected = wordlist[index];              
            int matches = master.guess(selected);                             
            if (matches == 6) return;                        
            for (int k =0; k < length; k++){
                if (countMatches(selected, wordlist[k]) != matches){                    
					length--;
                    wordlist[k] = wordlist[length];
                }
            }
            
        }        
    }
    
    private int countMatches(String s1, String s2){
        int matches = 0;
        for (int i = 0; i < 6; i ++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                matches++;
            }
        }        
        return matches;
    }
}