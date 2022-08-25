class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ch=new int[26];
        for(int i=0;i<magazine.length();i++)
        {
            ch[magazine.charAt(i)-'a']+=1;   
        }
        
        for(int i=0;i<ransomNote.length();i++)
        {
            if(--ch[ransomNote.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }
}