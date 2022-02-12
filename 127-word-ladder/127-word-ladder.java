class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //if(!wordList.contains(endWord)) return 0;
        Set<String> set= new HashSet<>(wordList);
        Queue<String> queue= new LinkedList<>();
        queue.add(beginWord);
        int count=1;
        Set<Character> cset= new HashSet<>();
        for(String w: wordList)
        {
            for( int i=0;i<w.length();i++)
            {
                char c= w.charAt(i);
                if(!cset.contains(c))
                             cset.add(c);
            }
        }
        while(!queue.isEmpty())
        {  
            int size= queue.size();
            for( int i=0;i<size;i++)
            {
                char[] current= queue.poll().toCharArray();
                for(int j=0;j<current.length;j++)
                {  
                    char tmp= current[j];
                  for(Character c: cset)
                 {
                   current[j]=c;
                     String next= new String(current);
                     if(set.contains(next))
                     {
                         if(next.equals(endWord)) return count+1;
                         queue.add(next);
                         set.remove(next);
                     }
                 }
                   current[j]=tmp;
                     }
                }
            count++;
        }
        return 0;
    }
}