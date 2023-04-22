class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();              
        stack.push(0);                                      
        
        int maxLen = 0;
        for(String str: input.split("\n")) {
            int level = str.lastIndexOf("\t")+1;            
            while(level+1 < stack.size()) {                 
                stack.pop();  
            }      
            
            int currLen = stack.peek()+str.length()-level+1;      
            stack.push(currLen);
            if(str.indexOf('.') != -1) {                   
                maxLen = Math.max(maxLen, currLen-1);       
            }
        }
        
    
        
        return maxLen;
    }
}