class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> arr=new ArrayList();
        Arrays.sort(nums);
        int i,temp=0;
        int sum=0;
        for(i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
        }
        for(i=nums.length-1; i>=0 && temp<=sum/2;i--)
        {
            arr.add(nums[i]);
            temp+=nums[i];
        }
        return arr;
    }
}