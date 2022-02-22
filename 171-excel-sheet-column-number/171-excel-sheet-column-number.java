class Solution {
    public int titleToNumber(String columnTitle) {
         int result = 0;
        int exponent = 0;
        char[] chars = columnTitle.toCharArray();
        for(int i=chars.length-1; i >= 0; i--){
            result += ((chars[i]-64) * Math.pow(26,exponent));
            exponent++;
        }
        return result;
    }
}