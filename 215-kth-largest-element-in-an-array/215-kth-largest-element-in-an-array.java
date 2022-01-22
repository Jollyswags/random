class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i,j;
        for(i=0;i<k;i++)
            pq.offer(nums[i]);
        for(j=k;j<nums.length;j++)
        {
            if(pq.peek()<nums[j])
            {
                pq.poll();
                pq.add(nums[j]);
            }
        }
        return pq.poll();
    }
}