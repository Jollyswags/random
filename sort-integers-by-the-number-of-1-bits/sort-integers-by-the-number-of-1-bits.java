class Solution {
    public int[] sortByBits(int[] arr) {
        int[] bits = new int[arr.length];
        int count;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            count=0;
            int n=arr[i];
            while(n>0){
                if((n&1)==1)
                    count++;
                n=n>>1;
            }
            bits[i]=count;

        }
        for(int i=0; i<bits.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(bits[j-1]>bits[j]){
                    int tempb=bits[j-1];
                    int tempa=arr[j-1];
                    bits[j-1]=bits[j];
                    arr[j-1]=arr[j];
                    bits[j]=tempb;
                    arr[j]=tempa;
                }
            }
        }
        return arr;
    }
}