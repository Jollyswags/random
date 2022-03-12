class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> chars = new Stack();
        Stack<Integer> combo = new Stack();
        
        
        for(char c: s.toCharArray()){
            if(!chars.isEmpty() && chars.peek() == c)
                combo.push(combo.peek() + 1);
            else combo.push(1);
            
            chars.push(c);
            if(combo.peek() == k){
                for(int i=0;i<k;i++){
                    chars.pop();
                    combo.pop();
        }}}

        StringBuilder sb = new StringBuilder();
        while(!chars.isEmpty()) sb.append(chars.pop());
        return sb.reverse().toString();
    }
}