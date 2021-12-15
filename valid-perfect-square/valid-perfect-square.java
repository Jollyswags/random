class Solution {
    public boolean isPerfectSquare(int num) {
         // If num is 0 return false
        if(num == 0){
            return false;
        }
        
        // long datatype can holds huge number.
        long start = 0;
        long end  = num;
        long mid = 0;
        
        // untill start is lesser or equal to end do this
        while(start <= end){
            
            //Finding middle value
            mid = start + (end - start) /2;
            
            // if mid*mid == num return true
            if(mid*mid == num){
                return true;
            }
            
            // if num is greater than mid*mid then make start = mid + 1
            else if(mid*mid < num){
                start = mid + 1;
            }
            
            // if num is lesser than mid*mid then make end = mid - 1
            else if(mid*mid > num){
                end = mid - 1;
            }
        }
        return false;  
    }
}