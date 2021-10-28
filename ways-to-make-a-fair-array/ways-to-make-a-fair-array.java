class Solution {
    public int waysToMakeFair(int[] nums) {
          if(nums.length <= 2){
            return nums.length;
        }
        
        int oddBefore = 0; int oddAfter = 0;
        int evenBefore = 0; int evenAfter = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            if(i % 2 ==0){
                evenAfter += nums[i];
            }else{
                oddAfter += nums[i];
            }
            
        }
        
        
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            int sum1; int sum2;
            if(i%2 == 0){
                sum1 = evenBefore + oddAfter;
                sum2 = oddBefore + evenAfter - nums[i];
            }else{
                sum1 = evenBefore + oddAfter - nums[i];
                sum2 = oddBefore + evenAfter;
            }
            
            if(sum1 == sum2)
                cnt++;
            
            if(i % 2 == 0){
                evenBefore += nums[i];
                evenAfter -= nums[i];
            }else{
                oddBefore += nums[i];
                oddAfter -= nums[i];
            }
        }
        
        return cnt;
        
        
    }
}