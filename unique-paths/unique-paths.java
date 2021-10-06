class Solution {
    public int uniquePaths(int m, int n) {
             int N = (m-1) + (n-1); // no of steps in each valid path
        int r = m-1;
        /*
        N C m-1 OR
        N C n-1 would give number of such valid unique paths
        */
        double res = 1;
        for(int i=1; i<=r; i++){
            res = res* (N - r + i)/i; 
        }
        
        return (int) res;
    }
}