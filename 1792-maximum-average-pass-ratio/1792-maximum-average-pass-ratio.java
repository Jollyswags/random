class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
          PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // compare the increase ratio
            double fir = ((double) a[0] + 1)/(a[1] + 1) - ((double) a[0])/(a[1]);
            double sec = ((double) b[0] + 1)/(b[1] + 1) - ((double) b[0])/(b[1]);
            return Double.compare(sec, fir);
        });
        int n = classes.length;
        for (int i = 0; i<n; i++) {
            if (classes[i][0]==classes[i][1]) continue;
            pq.add(new int[] {classes[i][0], classes[i][1]});
        }
        if (pq.size()>0) {
            while (extraStudents>0) {
                int [] cur = pq.poll();
                cur[0]++; cur[1]++;
                pq.add(cur);
                extraStudents--;
            }
        }
        double total = n-pq.size();
        while (pq.size()>0) {
            int [] v = pq.poll();
            total+=((double) v[0]/v[1]);
        }
        return total/n;
    }
}