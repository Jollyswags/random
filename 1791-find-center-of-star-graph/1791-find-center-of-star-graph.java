class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        int k=0;
        int len=edges.length;
        System.out.println(len);
        for(int edge[] : edges)
        {
            int u=edge[0];
            int v=edge[1];
            if(!map.containsKey(u))
                map.put(u,new ArrayList<>());
            map.get(u).add(v);
            if(!map.containsKey(v))
                map.put(v,new ArrayList<>());
            map.get(v).add(u);
            
        }
        System.out.println(map);
        for(int i: map.keySet())
        {
            List l=map.get(i);
            System.out.println(l.size());
            if(l.size()==len)
            {
                k=i;
                break;
            }
        }
        return k;
    }
}