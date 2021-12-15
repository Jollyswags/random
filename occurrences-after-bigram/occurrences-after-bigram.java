class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        int count=0;
        String[] s =text.split(" ");
        String[] result =new String[s.length];
        for (int i = 0; i < s.length-2; i++)
        {
            if (first.equals(s[i]) && second.equals(s[i+1]))
            {
                result[count] = s[i + 2];
                count++;
            }
        }
        return Arrays.copyOfRange(result,0,count);
    }
}