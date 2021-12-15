class Solution {
   public static boolean check(String str,String word) {
        for(char ch : word.toCharArray()) {
            if(str.indexOf(ch) < 0) return false;
        }
        return true;
    }
    
    public String[] findWords(String[] words) {
        List<String> arr = new ArrayList<>();
        for(String word : words) {
            String w = word.toLowerCase();
            if(check("qwertyuiop",w) || check("asdfghjkl", w) || check("zxcvbnm", w)) {
                arr.add(word);
            }
        }
        String[] ans = new String[arr.size()];
        ans = arr.toArray(ans);
        return ans;
    }
}