class Solution {
    public List<Integer> findDuplicates(int[] nums) {
          LinkedList <Integer> l=new LinkedList <Integer> ();
        HashMap <Integer,Integer> m=new HashMap <Integer,Integer> ();
        for(int i:nums)
        {
            if(m.containsKey(i))
            {
                m.put(i,2);    
            }
            else
            {
                m.put(i,1);
            }
        }
        for(int i:m.keySet())
        {
            if(m.get(i)==2)
            {
                l.add(i);
            }
        }
        return l;
    }
}