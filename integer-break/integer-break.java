class Solution {
    public int integerBreak(int n) {
         int res = 0;
        int three = n / 3;
        int rest = n % 3;
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (rest == 0) {
            res = (int) Math.pow(3, three);
        } else if (rest == 1){
            res = (int) Math.pow(3, three - 1) * (rest + 3);
        } else if (rest == 2){
            res = (int) Math.pow(3, three) * (rest);
        }
        return res;
    }
}