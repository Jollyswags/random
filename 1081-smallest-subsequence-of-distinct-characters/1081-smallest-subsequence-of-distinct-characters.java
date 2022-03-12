class Solution {
    public String smallestSubsequence(String s) {
        
        Stack<Character> stack=new Stack<>();//for storing the character in lexiographical orer
        int[] freq=new int[26];//for calculating the frequency of the alphabet 
        boolean[] exists=new boolean[26];//alphabet either exits in the stack or not (default all are false )
        
        for(int i=0;i<s.length();i++)//traversing 
        {//while we are dealing with minus in character ASCII substraction is done 
            char ch=s.charAt(i);
            freq[ch-'a']+=1;//calculating the frequency i.e; a=0,b=1,...
        }
        
        for(int i=0;i<s.length();i++)//traversing 
        {
            char ch=s.charAt(i);//extracting the Character
            
            freq[ch-'a']-=1;//as we are dealing with that Character, we are decreasing its frequency
            
            if(exists[ch-'a']==true)//if it already exits in the stack we proceed to next character 
                continue;//moves to the next iteration 
            
            while(stack.size()>0 && stack.peek() >ch && freq[stack.peek()-'a']>0)//if stack top element is greater than the current element and the f>0
            {
                exists[stack.pop()-'a']=false;//we pop it and flag it with false as its removed 
            }
            
            stack.push(ch);//pushing the character if it is greater than the previous(top)
            exists[ch-'a']=true;//making the flag true 
        }
        
        char[] res=new char[stack.size()];//resultant array 
        int i=res.length-1;
        while(i>=0)
        {
            res[i]=stack.pop();//popping
	
            i-=1;
        }
        return new String(res);
    }
}