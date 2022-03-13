class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int i:arr)
        {
             map.put(i,map.getOrDefault(i,0)+1);
            set.add(i);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int i: set)
        {
            pq.add(new int[]{i,map.get(i)});
        }
        while(k-->0)
        {
            int t[]=pq.poll();
            if(t[1]-1>0)
                pq.add(new int[]{t[0],t[1]-1});
        }
        
        return pq.size();
    }
}