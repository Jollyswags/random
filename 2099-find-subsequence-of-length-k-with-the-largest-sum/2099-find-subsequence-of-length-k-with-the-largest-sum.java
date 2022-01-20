class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
         int n = nums.length; 
        if (k == 0) return new int[0]; 
        if (k == n) return nums;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]); 
        
        for(int i = 0; i < n; i++) {
            minHeap.add(new int[] {nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[][] res = new int[k][2]; 
        for(int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        
        Arrays.sort(res, Comparator.comparingInt(pair -> pair[1]));
        return Arrays.stream(res).map(pair -> pair[0]).mapToInt(Integer::intValue).toArray();
       
    }
}