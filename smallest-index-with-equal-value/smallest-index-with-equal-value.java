class Solution {
    public int smallestEqual(int[] nums) {
          return IntStream.range(0, nums.length).dropWhile(i -> i % 10 != nums[i]).findFirst().orElse(-1);
        
    }
}