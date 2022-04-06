class Solution {
    public int specialArray(int[] nums) {
         int n = nums.length;
        int [] arr = new int [n + 1];
        for(int i = 0; i < n; i++){
            if(nums[i] < n)
                arr[nums[i]]++;
            else{
                arr[n]++;
            }
        }
        for(int i = n; i > 0; i--){
            if(arr[i] == i)
                return i;
            arr[i - 1] += arr[i];            
        }
        return n == 0? 0 : -1;
    }
}