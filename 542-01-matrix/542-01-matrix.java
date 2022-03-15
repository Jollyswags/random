class Solution {
    public int[][] updateMatrix(int[][] mat) {
          int R = mat.length, C = mat[0].length;
	// since diagonal doesn't count, the longest path is really the length of the matrix, minus itself and overlapped
	// given that there will always be a zero, this value can be anything big enough.
	int max = R + C - 2;
	int[][] ans = new int[R][C];
	// scan left to right, top to bottom
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (mat[i][j] == 0) {
				continue;
			}
			if ((i - 1 >= 0 && mat[i - 1][j] == 0) || (j - 1 >= 0 && mat[i][j - 1] == 0)) {
				ans[i][j] = 1;
			} else {
				ans[i][j] = 1 + Math.min(i - 1 >= 0 ? ans[i - 1][j] : max,
										 j - 1 >= 0 ? ans[i][j - 1] : max);
			}
		}
	}
	// scan bottom to top, right to left
	for (int i = R - 1; i >= 0; i--) {
		for (int j = C - 1; j >= 0; j--) {
			if (mat[i][j] == 0) {
				continue;
			}
			if ((i + 1 < R && mat[i + 1][j] == 0) || (j + 1 < C && mat[i][j + 1] == 0)) {
				ans[i][j] = 1;
			} else {
				int dist = 1 + Math.min(i + 1 < R ? ans[i + 1][j] : max,
										j + 1 < C ? ans[i][j + 1] : max);
				// combine result
				ans[i][j] = Math.min(ans[i][j], dist);
			}
		}
	}
	return ans;  
    }
}