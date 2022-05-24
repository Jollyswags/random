class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ts = new HashSet();
        HashMap<Integer, Integer> map = new HashMap();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i = 0 ; i < nums.length; i++){
            int f = nums[i];
            for(int j = i+1; j< nums.length; j++){
                List<Integer> l = new ArrayList();
                int s = nums[j];
                int t = 0 - f - s;
                if(map.containsKey(t) && map.get(t)>j){
                    l.add(f);
                    l.add(s);
                    l.add(t);
                    ts.add(l);
                }
            }
        }
        return new ArrayList(ts);
    }
}