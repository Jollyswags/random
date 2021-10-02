class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        Arrays.sort(nums);
        int start = 0;
        for (int j=0; j < nums.length; j++){
            if (j==0 || nums[j] != nums[j-1]) start = 0;  // When there are no duplicates
            int size = subsets.size(); // Keeping track of the subsets size before adding the new set of elements
            for(int i=start; i < size; i++){
                List<Integer> copied = new ArrayList<>(subsets.get(i));
                copied.add(nums[j]);
                subsets.add(copied);
            }
            start=size; // When there are duplicates, start pointer of the subsets will point to the first subset that was added recently
        }
        return subsets; 
    }
}