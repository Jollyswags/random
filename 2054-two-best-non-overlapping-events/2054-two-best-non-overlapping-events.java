class Solution {
    public int maxTwoEvents(int[][] events) {
         Arrays.sort(events, (event1, event2) -> Integer.compare(event1[0], event2[0]));
        
        // maintaining the end times of previous events to use for checking overlap
        PriorityQueue<int[]> endTimes = new PriorityQueue<>((event1, event2) -> Integer.compare(event1[1], event2[1]));
        
        // finally, max-valued event we've seen thus far
        int maxValuedEvent = 0;
        int ans = 0;
        
        // now start the iterative process
        for (int[] event : events) {
            while (!endTimes.isEmpty() && endTimes.peek()[1] < event[0]) {
                maxValuedEvent = Math.max(maxValuedEvent, endTimes.poll()[2]);
            }
            ans = Math.max(ans, maxValuedEvent + event[2]);
            endTimes.offer(event);
        }
        return ans;
    }
}