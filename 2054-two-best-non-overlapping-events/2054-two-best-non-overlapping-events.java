class Solution {
    public int maxTwoEvents(int[][] events) {
        // -sort the events by start time
        // -rely on the fact that for any event events[i], all events after events[i] start at a time
        // after events[i] and so do not overlap with any previous events not overlapping with events[i].
        // hence, we can maintain a PQ of end times for events to keep track of which events don't overlap with
        // the current event,
        // and maintain a maximum-valued previous event to combine with curr events[i]
        // answer will either be using two or one event sine value is nonnegative
        
        // sort events by start time
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