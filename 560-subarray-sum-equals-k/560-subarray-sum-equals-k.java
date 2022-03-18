class Solution {
    public int subarraySum(int[] nums, int sum) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int res=0;
        int i,currsum=0;
        map.put(0,1);
        for(i=0;i<nums.length;i++)
        {
            currsum+=nums[i];
          
            if(map.containsKey(currsum-sum))
            {
                res+=map.get(currsum-sum);
            }
            Integer c=map.get(currsum);
            if(c==null)
                map.put(currsum,1);
            else
                map.put(currsum,c+1);
        }
        return res;
    }
}