class Solution {
    public void sortColors(int[] a) {
         int zeroes=0,ones=0,twos=0; //counting each number of color
        for(int i=0;i<a.length;i++){
            if(a[i]==0)
                a[zeroes++]=0;   //counting and setting 0(Red) to save loops down the road
            else if(a[i]==1)
                ones++;   //counting ones (green)
            else
                twos++; //counting twos (blue)
        }
        for(int i=zeroes;i<zeroes+ones;i++)  //setting 1s after all the zeroes 
            a[i]=1;
        for(int i=zeroes+ones;i<a.length;i++) //setting 2s after all the ones
            a[i]=2;
    }
}