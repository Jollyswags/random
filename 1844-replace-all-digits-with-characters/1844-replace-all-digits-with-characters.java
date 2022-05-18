class Solution {
    public String replaceDigits(String s) {
      //  int i='a';
       // i='a'+1;
        String str="";
        
      int l= s.length();
        int i;
        for(i=0;i<l;i++)
        {
            if(i%2==0)
                str+=s.charAt(i);
            else
            {
                int k=s.charAt(i-1)+Character.getNumericValue(s.charAt(i));;
                str+=(char)k;
            }
                
        }
       // System.out.println((char)i);
        return str;
        
    }
}