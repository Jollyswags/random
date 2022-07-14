class Solution {
    public String removeKdigits(String num, int k) {
         int len = num.length();
        if(k==0)return num;
        if(k==len)return "0";
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<num.length()){
            while(k>0 && !st.isEmpty() && st.peek()>num.charAt(i)){
                st.pop();
                k--;
                
            }
            st.push(num.charAt(i));
            i++;
        }
        
        while(k-- > 0){
            st.pop();
        }
        String smallest = "";
        while(st.size()!=0){
            smallest = st.pop()+smallest;
        }
        while(smallest.length()>1 && smallest.charAt(0)=='0'){
            smallest = smallest.substring(1);
        }
        return smallest; 
    }
}