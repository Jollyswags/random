class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        
        double[][] workers = new double[quality.length][2];
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        double result = Integer.MAX_VALUE;
        for(int i = 0; i < quality.length; i++) {
            workers[i][0] = (double) wage[i] / (double) quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, (o1, o2) -> {
            if(o1[0] - o2[0] == 0) return 0;
            if(o1[0] - o2[0] > 0) return 1;
            return -1;
        });
        for(double[] worker : workers) {
            if(heap.size() == K) {
                sum -= heap.poll();
            }
            heap.add(worker[1]);
            sum += worker[1];
            if(heap.size() == K) {
                result = Math.min(result, sum * worker[0]);
            }
        }
        return result;
    }
}