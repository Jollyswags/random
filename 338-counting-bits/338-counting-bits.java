class Solution {
    public int[] countBits(int n) {
        int bits[]=new int[n+1];
       
        int i;
        for(i=0;i<=n;i++)
        {
            if(i%2==0)
                bits[i]=bits[i/2];
            else
                bits[i]=bits[i/2]+1;
        }
        return bits;
    }
}