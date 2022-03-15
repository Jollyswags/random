class Solution {
    public String removeKdigits(String num, int k) {
    int n=num.length();
        Stack<Character>s=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=num.charAt(i);
            while(k>0&&s.size()>0&&s.peek()>ch){
                s.pop();
                k--;
            }
            s.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(s.size()>0){
            char ch=s.pop();
            if(ch!='0'&&k>0){
                k--;
            }
            else sb.append(ch);
        }
        sb=sb.reverse();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!='0'){
                return sb.substring(i);
            }
        }
        return "0";
    }
}