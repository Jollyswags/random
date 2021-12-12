class Solution {
    public String[] uncommonFromSentences(String A, String B) {
       
        String str=A+" "+B;
        String words[]=str.split(" ");
        List<String> list = new LinkedList<String>();
        
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
       for(String i: map.keySet())
       {
           if(map.get(i)==1)
               list.add(i);
               
       }
        return list.toArray(new String[0]);
    }
}