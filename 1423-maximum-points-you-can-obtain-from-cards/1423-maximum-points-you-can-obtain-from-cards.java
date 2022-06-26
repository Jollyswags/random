class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        
        if(k == cardPoints.length){
            for(int val : cardPoints){
                ans += val;
            }
            
            return ans;
        }
        
        int left_sum = 0, right_sum=0, osum = 0;
       
        for(int i=0; i<k; i++){
            left_sum += cardPoints[i];
        }
        
        int i=k-1, j=cardPoints.length;
        while(i >= 0){
           osum = left_sum + right_sum; 
           ans = Math.max(ans, osum);
           left_sum -= cardPoints[i--];
           right_sum += cardPoints[--j]; 
        }
        
        ans = Math.max(ans, left_sum + right_sum);
        
        return ans;
    }
}