class Solution {
   private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final char VISITED = '\0';
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.isEmpty()) return true;
        final int M = board.length, N = board[0].length, L = word.length();
        if (M*N < L) return false;
        char target = word.charAt(0);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == target) {
                    if (dfs(board, i, j, word, 1)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int x, int y, String word, int z) {
        if (z >= word.length()) return true;
        char target = word.charAt(z);
        char temp = board[x][y];
        board[x][y] = VISITED;
        for (int[] dir : DIRS) {
            int i = dir[0] + x;
            int j = dir[1] + y;
            if (outOfBound(board, i, j) || board[i][j] != target) continue;
            if (dfs(board, i, j, word, z+1)) {
                board[x][y] = temp;
                return true;
            }
        }
        board[x][y] = temp;
        return false;
    }
    
    private boolean outOfBound(char[][] board, int i, int j) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length;
    }
}