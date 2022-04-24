class Solution {
    public int subarraySum(int[] nums, int sum) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int res=0;
        int i,currsum=0;
        map.put(0,1);
        for(i=0;i<nums.length;i++)
        {
            currsum+=nums[i];
          
           res+=map.getOrDefault(currsum-sum,0);
            map.put(currsum,map.getOrDefault(currsum,0)+1);
        }
        return res;
    }
}