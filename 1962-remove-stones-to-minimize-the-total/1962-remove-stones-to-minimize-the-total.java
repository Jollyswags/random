class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int n:piles)
        {
            pq.add(n);
        }
        while(k>0)
        {
            int p=pq.poll();
            int x=(int)Math.floor((double)p/2.0);
            pq.add(p-x);
            k--;
        }
        int s=0;
        while(!pq.isEmpty())
        {
            s+=pq.poll();
        }
        return s;
    }
}