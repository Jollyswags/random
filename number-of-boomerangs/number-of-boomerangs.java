class Solution {
   public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length <= 1) return 0;
        final int N = points.length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            int[] p1 = points[i];
            Map<Integer, Integer> map = new HashMap<>(N-1);  // Record the <distance, count> pairs
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                int[] p2 = points[j];
                int distance = distance(p1, p2);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int count : map.values()) {  // count * (count - 1) combinations of boomerang tuple
                res += count * (count - 1);
            }
        }
        return res;
    }
    
    private int distance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}