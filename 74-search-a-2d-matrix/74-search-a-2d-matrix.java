class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0, right = m*n-1;
        int mid;
        
        while (left <= right) {
            mid = left + (right-left)/2;
            
            int x = mid / n;
            int y = mid % n;
            
            if (target == matrix[x][y]) return true;
            
            if (target > matrix[x][y]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return false;
    }
}