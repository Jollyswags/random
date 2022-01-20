class Solution {
    public String frequencySort(String s) {
         HashMap<Character,Integer> tm = new HashMap<>();
    Queue<Character> heap = new PriorityQueue<>((a,b) -> (tm.get(b)-tm.get(a)));   // sort the heap based on the freq of characters
    String ans = "";
	
    for(Character c:s.toCharArray())
        tm.put(c,tm.getOrDefault(c,0)+1);
    for(Character c:tm.keySet())
        heap.add(c);
		
    while(heap.size()>0){
        Character chr = heap.poll();
        for(int i=0;i<tm.get(chr);i++)
            ans += chr;
    }
    return ans;
    }
}