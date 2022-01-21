class Solution {
    public int lastStoneWeight(int[] stones) {
         if(stones.length == 1)
            return stones[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones)
            heap.offer(stone);
        
        while(heap.size() > 1){
            int big = heap.poll();
            int small = heap.poll();
            if(big != small)
                heap.add(big-small);
        }
        if(heap.size() == 0)
            return 0;
        else
            return heap.peek();
    }
}