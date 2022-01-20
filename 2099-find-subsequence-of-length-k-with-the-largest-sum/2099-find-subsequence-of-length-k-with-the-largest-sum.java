class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
      PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int i,l=nums.length,j;
        for(i=0;i<k;i++)
        {
            pq.add(new int[]{nums[i],i});
        }
        for(j=k;j<l;j++)
        {
            if(pq.peek()[0]<nums[j])
            {
                pq.poll();
                pq.add(new int[]{nums[j],j});
            }
        }
        int res[][]=new int[k][2];
        while(!pq.isEmpty())
        {
            res[--k]=pq.poll();
        }
        
        Arrays.sort(res, Comparator.comparingInt(pair->pair[1]));
        return Arrays.stream(res).map(pair -> pair[0]).mapToInt(Integer::intValue).toArray();
       
    }
}