class Solution {
    public int maxArea(int[] height) {
        int vol;
        int max=0;
        int i=0,j=height.length-1;
        while(i<j){
           if(height[i]<height[j]){
               vol = (j-i)*height[i];
               i++;
           }else{
               vol = (j-i)*height[j];
               j--;
           }
            max=Math.max(max,vol);
       }           
         return max;
    }
}