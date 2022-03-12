class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(st.isEmpty() || ch != 'c'){
                st.push(ch); 
            }else{
                boolean flag = false; 
                if(!st.isEmpty() && st.peek() == 'b'){
                    st.pop();
                    if(!st.isEmpty() && st.peek() == 'a'){
                        st.pop();
                        flag = true;
                    }
                    
                }
                if(flag == false){
                    st.push(ch);
                }
            }
        }
        
        return st.size() == 0 ? true : false;
    }
}