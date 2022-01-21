class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int cur[] = new int[primes.length];
		int ans=1;
		int dp[] = new int[n+1];
		dp[0]=1;
		int index=1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<primes.length;i++)
			pq.add(primes[i]);

		while(index<n){
			int min=pq.poll();
			while(!pq.isEmpty() && min==pq.peek()) //check for duplicate values
				pq.poll();
			dp[index++]=min;
			for(int i=0;i<primes.length;i++){
				if(min == dp[cur[i]]*primes[i]){
					cur[i]++;
					pq.add(dp[cur[i]]*primes[i]);
				}
			}
		}
		return dp[n-1];
    }
}