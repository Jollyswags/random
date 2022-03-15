class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
     LinkedList<int[]> queue = new LinkedList<>();
        int[] interval;
        
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        //step-1 :  Add all the value to queue if the current interval's start time is less than newInterval's start time
        int row = 0;
        while (row < intervals.length && intervals[row][0] < newInterval[0]) {
            interval = intervals[row];
            queue.add(interval);
            row++;
        }

        /*
         *  Step-2 : Now there can be two cases
         *            case-1 : Nothing is there in the queue, in that case add the newInterval
         *            Case-2 : Queue has some value, so, check the last interval's EndTime is greater than newInterval's start time.  
         *                     If so merge it.
         */
        if (!queue.isEmpty() && queue.getLast()[1] >= newInterval[0]) {
            queue.getLast()[1] = Math.max(queue.getLast()[1], newInterval[1]);
        } 
        else {
            queue.add(newInterval);
        }

        /*
         * Step-3 : Need to add the rest of the intervals, which can have again two case
         *              Case-1 : Queue has some value, so, check the last interval's EndTime is greater than current Interval's start time. 
         *                       If so merge it.
         *              Case-2 : Queue has some value but the last interval's EndTime is less than current Interval's start time. 
         *                       So add it freshly.
         */
        for (int i = row; i < intervals.length; i++) {
            if (queue.getLast()[1] >= intervals[i][0]) {
                queue.getLast()[1] = Math.max(queue.getLast()[1], intervals[i][1]);
            } else {
                interval = intervals[i];
                queue.add(interval);
            }
        }
        return queue.toArray(new int[queue.size()][]);
    
    }
}