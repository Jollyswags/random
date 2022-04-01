class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(m-1).size();
        int[] min = new int[n+1];
        for (int i=m-1; i >=0; i--) {
            for (int j=0; j <= i; j++) {
                min[j] = Math.min(min[j], min[j+1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }
}