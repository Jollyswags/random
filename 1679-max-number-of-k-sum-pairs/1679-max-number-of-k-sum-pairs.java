class Solution {
    public int maxOperations(int[] nums, int k) {
         Map<Integer, Integer> maps=new HashMap<>();
       int c=0;
        for(int n:nums)
        {
            if(maps.containsKey(k-n) && maps.get(k-n)>0)
        {
            c++;
            maps.put(k-n,maps.get(k-n)-1);
        }
        else
        {
            maps.put(n,maps.getOrDefault(n,0)+1);
        }
        }
        return c;
    }
}