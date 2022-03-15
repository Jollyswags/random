class Solution {
     List<Integer> list = new ArrayList<>();
    List<List<Integer>> ansList = new ArrayList<>();

    void helper(int[] nums) {

        if (list.size() == nums.length)
            ansList.add(new ArrayList<>(list));

        else {

            for (int i = 0; i < nums.length; i++) {

                if (list.contains(nums[i]))
                    continue;

                list.add(nums[i]);
                helper(nums);
                list.remove(list.size() - 1);

            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        helper(nums);
        return ansList;
    }
}