class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map <String, Integer> map = new HashMap<String, Integer>();
        for (String s : words)
            map.put(s, map.getOrDefault(s, 0)+1);
        PriorityQueue <Map.Entry<String, Integer>> q
            = new PriorityQueue<>(
                (a,b) -> a.getValue() != b.getValue() 
                        ? -1 * a.getValue().compareTo(b.getValue())     // get max frequency at top 
                        : a.getKey().compareTo(b.getKey())              // if frequency same get the lexical order
        );
        for (Map.Entry <String, Integer> m : map.entrySet())
            q.add(m);
        List <String> res = new ArrayList<>();
        for(int i=0;i<k;++i)
            res.add(q.poll().getKey());
        return res;
    }
}