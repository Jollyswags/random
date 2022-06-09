class Solution {
    List<Integer> list;
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        ans = new ArrayList<>();
        helper(nums);
        return ans;
    }
    public void helper(int nums[])
    {
        if(list.size()== nums.length)
            ans.add(new ArrayList<>(list));
        else
        {
            for(int i=0; i<nums.length; i++)
            {
                if(list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                helper(nums);
                list.remove(list.size()-1);
            }
        }
            
    }
}