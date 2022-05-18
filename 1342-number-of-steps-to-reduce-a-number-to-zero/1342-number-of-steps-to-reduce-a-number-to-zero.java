class Solution {
    public int numberOfSteps(int num) {
         int total = 0;
        while(num  > 1) {
            total++;
            total += num & 1;
            num >>= 1;
        }
        return total + (num & 1);
    
    }
}