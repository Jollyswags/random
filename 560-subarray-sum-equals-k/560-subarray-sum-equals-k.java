class Solution {
    public int subarraySum(int[] nums, int sum) {
         HashMap<Integer, Integer> prev = new HashMap<>();
        int res=0;
        int i,currsum=0;
        for(i=0;i<nums.length;i++)
        {
            currsum+=nums[i];
            if(currsum==sum)
                res++;
            if(prev.containsKey(currsum-sum))
                res+=prev.get(currsum-sum);
          Integer  c=prev.get(currsum);
            if(c == null)
                prev.put(currsum,1);
            else
                prev.put(currsum,c+1);
            
        }
        return res;
    }
}