class Solution {
    public String sortSentence(String s) {
        String words[]=s.split(" ");
        HashMap<Integer, String> map=new HashMap<>();
        int i;
        for(String w: words)
        {
            
            i=Character.getNumericValue(w.charAt(w.length()-1));
            map.put(i,w);
        }
        String str="";
        String result="";
        for(i=1;i<=9;i++)
        {
            if(map.get(i)!=null)
            {
               str+=map.get(i);  
                 str=str.substring(0,str.length()-1)+ " ";
            }
           
                       
        }
       
        return str.substring(0,str.length()-1);
        
    }
}