class Solution {
    public int minimumLength(String s) {
        int leftIndex = 0;
            int rightIndex = s.length()-1;
            while (leftIndex<rightIndex && s.charAt(leftIndex) == s.charAt(rightIndex)){
                char ch = s.charAt(leftIndex);
                while (s.charAt(leftIndex) == ch && leftIndex<rightIndex){
                    leftIndex++;
                }
                while (s.charAt(rightIndex) == ch && leftIndex<=rightIndex){
                    rightIndex--;
                }
            }

            return rightIndex-leftIndex+1;
    }
}