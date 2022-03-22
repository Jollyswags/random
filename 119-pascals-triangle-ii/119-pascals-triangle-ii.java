class Solution {
    public List<Integer> getRow(int N) {
          List<List<Integer>> result = new ArrayList<>();
          List<Integer> r = new ArrayList<>();
          r.add(1);
        if(N==0)
            return r;
        if(N==1) {
            r.add(1);
            result.add(r);
            return result.get(0);
        }

        int dp[][] = new int[N+1][N+1];
        dp[0][0]=1;
        dp[1][0]=dp[1][1]=1;
        for(int i=2; i<N+1; i++){
            for(int j=0; j<=i; j++){
                if(j==0 || j==i) dp[i][j]=1;
                else dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        for(int i=0; i<N+1; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<N+1; j++){
                if(dp[i][j] !=0) row.add(dp[i][j]);
            }
            result.add(row);
        }
        return result.get(N);
    }
}