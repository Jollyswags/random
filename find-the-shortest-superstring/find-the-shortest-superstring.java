class Solution {
   public String shortestSuperstring(String[] words) {
	int n = words.length;
	int[][] graph = new int[n][n];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			graph[i][j] = cal(words[i], words[j]);
			graph[j][i] = cal(words[j], words[i]);
		}
	}

	int[][] dp = new int[(1 << n)][n];
	int[][] parent = new int[1 << n][n];

	for (int s = 1; s < (1 << n); s++) 
		for (int j = 0; j < n; j++)
			dp[s][j] = 1000;
	for (int i = 0; i < n; i++) dp[1 << i][i] = words[i].length();

	for (int s = 1; s < (1 << n); s++) {
		for (int j = 0; j < n; j++) {
			if (s == (1 << j)) continue; // only node j itself.
			int ps = s & ~(1 << j);

			for (int i = 0; i < n; i++) {
				if (dp[ps][i] + graph[i][j] < dp[s][j]) {
					dp[s][j] = dp[ps][i] + graph[i][j];
					parent[s][j] = i;
				}
			}
		}
	}

	int min = Integer.MAX_VALUE, last = -1;
	for (int i = 0; i < n; i++) {
		if (dp[(1 << n) - 1][i] < min) {
			min = dp[(1 << n) - 1][i];
			last = i;
		}
	}
	
	// Generate the output
	int cur = (1 << n) - 1;
	Stack<Integer> stack = new Stack<>();
	while (cur > 0) {
		stack.push(last);
		int temp = cur & ~(1 << last);
		last = parent[cur][last];
		cur = temp;
	}
	
	StringBuilder sb = new StringBuilder();
	int i = stack.pop();
	sb.append(words[i]);
	while (!stack.isEmpty()) {
		int j = stack.pop();
		sb.append(words[j].substring(words[j].length() - graph[i][j]));
		i = j;
	}
	return sb.toString();
}

int cal(String a, String b) {
	int res = b.length();
	for (int i = 1; i < Math.min(a.length(), b.length()); i++) {
		if (a.substring(a.length() - i).equals(b.substring(0, i))) res = b.length() - i;
	}
	return res;
}
}