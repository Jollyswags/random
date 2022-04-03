class Solution {
    public int mctFromLeafValues(int[] arr) {
         Stack<Integer> stack = new Stack();
        int result = 0;
        
        for(int i = 0; i < arr.length; ++i) {
            while(!stack.empty() && stack.peek() <= arr[i])
                result += stack.pop() * (stack.empty() ? arr[i] : Math.min(stack.peek(), arr[i]));
            
            stack.push(arr[i]);
        }
        
        while(stack.size() > 1)
            result += stack.pop() * stack.peek();
        
        return result; 
    }
}