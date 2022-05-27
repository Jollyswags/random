class Solution {
    public int heightChecker(int[] heights) {
       int l=heights.length;
             int c=0,i;
        int expected[]=new int[l];
        for(i=0;i<l;i++)
            expected[i]=heights[i];
        Arrays.sort(heights);
   
        for(i=0;i<l;i++)
            if(expected[i]!=heights[i])
                c++;
        return c;
        
    }
}