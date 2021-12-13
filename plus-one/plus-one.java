class Solution {
    public int[] plusOne(int[] digits) {
        int i;
        String num1="";
        String num2="1";
        for(i=0;i<digits.length;i++)
            num1+=digits[i];
        
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;    
        }
        
        if (carry != 0)
            res.append(carry);
   String str=res.reverse().toString();
        int arr[]=new int[res.length()];
        for(i=0;i<arr.length;i++)
            arr[i]=str.charAt(i)-'0';
        return arr;
        
    }
}