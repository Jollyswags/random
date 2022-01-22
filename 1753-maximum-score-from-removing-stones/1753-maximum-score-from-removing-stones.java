class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int ans=0;
        while(pq.size()>1)
        {
           int a1=pq.poll();
           int b1=pq.poll();
            a1--;
            b1--;
            if(a1!=0)
                pq.add(a1);
            if(b1!=0)
                pq.add(b1);
            ans++;
        }
        return ans;

    }
}