 class Solution {
 public List<Integer> findSubstring(String s, String[] words) {
 	HashMap<String,Integer> hm1=new HashMap<>();
 	List<Integer> list=new ArrayList<>();
 
 for(String str:words)
      hm1.put(str,hm1.getOrDefault(str,0)+1);
 
 int len=words[0].length(),n=words.length;
 
 for(int st=0;st<=s.length()-len*n;st++)
 {
     HashMap<String,Integer> hm2=new HashMap<>();
     for(int i=0;i<words.length;i++)
     {
       String nstr=s.substring(i*len+st,i*len+st+len);
         if(hm1.containsKey(nstr))
         {
             hm2.put((nstr),hm2.getOrDefault(nstr,0)+1);
             if(hm2.get(nstr)>hm1.get(nstr))
                 break;
         }
         else
             break;
     }
     
     if(hm1.equals(hm2))
         list.add(st);
 }
 return list;
 }
 }