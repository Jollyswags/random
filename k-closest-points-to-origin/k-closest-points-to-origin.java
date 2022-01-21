class Solution {
    public int[][] kClosest(int[][] points, int k) {
       //HahMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int i=0,j;
        for(int point[]:points)
        {
            int x=point[0];
            x=x*x;
            int y=point[1];
            y=y*y;
            pq.offer(new int[]{(x+y),i});
            i++;
        }
        int res[][]=new int[k][2];
        for(j=0;j<k;j++)
        {
         i=pq.poll()[1];
            res[j]=points[i];
        }
        return res;
    }
}