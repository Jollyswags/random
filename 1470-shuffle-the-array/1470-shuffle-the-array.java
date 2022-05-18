class Solution {
    public int[] shuffle(int[] nums, int n) {
         int a[]=new int[nums.length];
        int i,j,k=0;
        for(i=0,j=nums.length/2; i<(nums.length/2) && j<nums.length;i++,j++)
        { 
            a[k++]=nums[i];
            a[k++]=nums[j];
        }
        return a;
        
    }
}