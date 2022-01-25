class Solution {
    public int kthSmallest(int[][] mat, int k) {
         List<Integer> list = new ArrayList<>();
        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
        int n = mat[0].length;
        for(int i=0; i<n; i++) {
            list.add(mat[0][i]);
        }
        for(int i=1; i<mat.length; i++) {
            int[] arr = mat[i];
            List<Integer> temp = new ArrayList<>();
            for(int num: list) {
                for(int x: arr) {
                    temp.add(num + x);
                }
            }
            Collections.sort(temp);
            list.clear();
            for(int j=0; j<Math.min(k, temp.size()); j++) {
                list.add(temp.get(j));
            }
        }
        return list.get(list.size() - 1);
    }
}