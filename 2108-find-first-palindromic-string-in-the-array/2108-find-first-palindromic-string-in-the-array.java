class Solution {
    public String firstPalindrome(String[] words) {
        for(String s: words)
        {
            StringBuilder rev=new StringBuilder();
            rev.append(s);
            rev.reverse();
            String r=rev.toString();
            if(r.equals(s))
                return r;
        }
        return "";
    }
}