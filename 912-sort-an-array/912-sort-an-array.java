class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i;
        for(i=0;i<nums.length;i++)
        {
            pq.offer(nums[i]);
        }
        i=0;
        while(!pq.isEmpty())
        {
            nums[i++]=pq.poll();
        }
        return nums;
    }
}