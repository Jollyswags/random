class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 1; i < heights.length; i++){
            if(heights[i] > heights[i - 1]){
                minHeap.add(heights[i] - heights[i - 1]);
                if(minHeap.size() > ladders){
                    bricks -= minHeap.poll();
                    if(bricks < 0)
                        return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}