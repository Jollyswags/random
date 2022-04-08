class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        int pos = 0;

        for (var ch : s.toCharArray())
          if ((ch == '(' && pos++ > 0) || (ch == ')' && --pos > 0))
            builder.append(ch);

        return builder.toString(); 
    }
}