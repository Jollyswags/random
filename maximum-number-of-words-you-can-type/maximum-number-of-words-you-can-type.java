class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
           if(text.isEmpty())
            return 0;
        
        if(brokenLetters.isEmpty())
            return text.split(" ").length;
        
        int [] arr = new int[26];
        int count = text.split(" ").length;
        for(char ch: brokenLetters.toCharArray()){
            arr[ch - 'a']++;
        }
        
        for(String str: text.split(" ")){// as qusetion says we need to find words in text
            boolean flag = false;
            for(char ch: str.toCharArray()){
                if(arr[ch -'a']> 0)
                   flag = true;

            }
            if(flag)
                count--;
         }
        return count;
    }
}