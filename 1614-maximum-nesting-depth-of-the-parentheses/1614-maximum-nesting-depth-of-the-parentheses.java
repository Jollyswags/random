class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack=new Stack<>();
        int max=0;
        for(char ch: s.toCharArray())
        {
            if(ch=='(')
                stack.push('(');
            if(ch==')')
            {
                max=Math.max(stack.size(),max);
                stack.pop();
            }
        }
        return max;
    }
}