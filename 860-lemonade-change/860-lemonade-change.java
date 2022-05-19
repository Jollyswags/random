class Solution {
    public boolean lemonadeChange(int[] bills) {
           int five = 0;
        int ten = 0;
        int twenty = 0;
        
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5) { five++; bills[i] -= 5;}
            if(bills[i] == 10) { ten++; bills[i] -= 5; }
            if(bills[i] == 20) { twenty++; bills[i] -= 5; }
            
            if(bills[i] > 0){
                while(bills[i] >= 20 && twenty > 0){
                    twenty--;
                    bills[i] -= 20;
                }
                
                while(bills[i] >= 10 && ten > 0){
                    ten--;
                    bills[i] -= 10;
                }
                
                while(bills[i] >= 5 && five > 0){
                    five--;
                    bills[i] -= 5;
                }
                
                if(bills[i] > 0) return false;
            } 
        }
        
        return true; 
        
    }
}