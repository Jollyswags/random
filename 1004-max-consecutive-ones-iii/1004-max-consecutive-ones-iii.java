class Solution {
    public boolean check(int[] nums, int atm, int k) {

        int i=0,j=0;
        
        int zCtr=0;
        
        while(j<nums.length){
            
            if(j-i+1<k){
                
                if(nums[j]==0)zCtr++;
                
                j++;
                
            }else{
                
                if(nums[j]==0)zCtr++;
                
                if(zCtr<=atm)return true;
                
                if(nums[i]==0)zCtr--;
                
                i++;
                j++;
                
            }
            
        }
        return false;
    }
    

public int longestOnes(int[] nums, int atm){
    
    int l = atm;
    int h = nums.length;
    
    int max=0;
    
    while(l<=h){
        
        int mid = (l+h)/2;
        
        if(check(nums, atm, mid)){
            max=Math.max(mid, max);
            l=mid+1;
        }else{
            h=mid-1;
        }
        
    }
    return max;
}
}