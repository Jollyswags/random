class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int i,j;
        for(i=0;i<k;i++)
            pq.offer(new int[]{nums[i],i});
        for(j=k;j<nums.length;j++)
        {
            if(pq.peek()[0]<nums[j] || ( pq.peek()[0]==nums[j]))
            {
                pq.poll();
                pq.add(new int[]{nums[j],j});
            }
        }
        return pq.poll()[0];
    }
}