class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(int b[]:boxTypes)
        {
            pq.add(b);
        }
        int ans=0;
        while(truckSize>0 && pq.size()>0)
        {
            int temp[]=pq.poll();
            if(truckSize>=temp[0])
            {
                ans+=temp[0]*temp[1];
                   truckSize-=temp[0];
            }
            else
            {
                  ans+=truckSize*temp[1];
                   truckSize=0;
            }
            
            
        }
        return ans;
    }
}
// TC: O(Nlog(N))
// SC:O(N)