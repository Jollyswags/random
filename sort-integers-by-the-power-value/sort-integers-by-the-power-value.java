class Solution {
    public int getKth(int lo, int hi, int k) {
           int[][] arr=new int[hi-lo+1][2];
        for(int i=lo;i<=hi;i++){
            arr[i-lo][0]=i;
            arr[i-lo][1]=power(i);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
               if(first[1] == second[1]){
                    if(first[0] < second[0])    return -1;
                   else return 1;
                }
                else{
                    if(first[1] < second[1])    return -1;
                    else    return 1;
                }
            }
        });
        return arr[k-1][0];
        
    }
    public int power(int lo)
    {
           if(lo == 1) return 1;
        if(lo%2 == 1)   return 1+ power((3*lo)+1);
        else    return 1+ power(lo/2);
    }
}