class Solution {
   public String reverseVowels(String s) {
      int l=0;
        int r=s.length()-1;
        char[] words=s.toCharArray();
        HashSet<Character> vowels=new HashSet<>();
        vowels.add('a'); vowels.add('A');
        vowels.add('e'); vowels.add('E');
        vowels.add('i'); vowels.add('I');
        vowels.add('o'); vowels.add('O');
        vowels.add('u'); vowels.add('U');
        
        while(l<r){
            char ch1=words[l];
            char ch2=words[r];
            if(vowels.contains(ch1) && vowels.contains(ch2)){
               swap(words,l,r);
                l++;
                r--;
            }else if(vowels.contains(ch1)){
                r--;
            }else if(vowels.contains(ch2)){
                l++;
            }else{
                l++;
                r--;
            }
        }
        String ans=new String(words);
        return ans;
    }
    
    private void swap(char[] arr,int i,int j){
         char temp=arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
    }   
}