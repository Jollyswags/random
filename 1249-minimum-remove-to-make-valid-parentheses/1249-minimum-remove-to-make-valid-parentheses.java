class Solution {
    public String minRemoveToMakeValid(String s) {
         Stack<Integer> stack=new Stack<>();
         Set<Integer> set=new HashSet<>();
         for(int i=0;i<s.length();i++){
             if(s.charAt(i)=='('){
                 stack.push(i);
             }
             else if(s.charAt(i)==')'){
                 if(stack.size()!=0){
                     stack.pop();
                 }
                 else{
                     set.add(i);
                 }
             }
             
         }
        
        
        while(!stack.isEmpty()){
            int idx=stack.pop();
            set.add(idx);
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}