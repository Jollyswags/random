class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) {
            return true;
        }
        // we sort the array according to the starting location
        Arrays.sort(trips, new Comparator<int[]>(){
             public int compare (int[] a, int[] b) {
                 // sort by the start location
                 return a[1] - b[1];
             }
        }); 
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[2]-b[2]));//end location
        
        for (int i = 0; i < trips.length; i++) {
            int[] drive = trips[i];
            int num = drive[0], start = drive[1];
            
            // pop all previous drives that already end
            while (!minHeap.isEmpty() && start >= minHeap.peek()[2]) {
                int[] prev = minHeap.poll();
                capacity = capacity + prev[0];
            }
            
            // pick new passengers, need to check capacity
            if (capacity >= num) {
                minHeap.offer(drive);
                capacity -= num;
            }
            else {
                return false;
            }
        }
        
        return true;   
    }
}