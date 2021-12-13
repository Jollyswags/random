class Solution {
    public String reorderSpaces(String text) {
           int spacesCount=0;
    String[] words=text.trim().split("\\s+");
        int wordsCount=words.length;
        if(wordsCount==1){
          
            spacesCount=text.length()-words[0].length();
            return words[0]+" ".repeat(spacesCount);
        }
        String word=words[0];
        int countX=0;
        for(int i=1;i<words.length;i++){
            word=word+"X"+words[i];
            countX++;
        }
        spacesCount=text.length()-word.length()+(countX);
       
        int c=spacesCount%(wordsCount-1); 
        String spaces=" ".repeat(spacesCount/(wordsCount-1));
        return word.replace("X",spaces) + " ".repeat(c);
        
        
    }
}