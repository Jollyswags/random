class Solution {
     private int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i<rows; i++ ){
            for(int j = 0; j<cols; j++ ){
                if (dfs(board, visited, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int idx){
        if (idx == word.length()) return true;
        if (x<0 || x>=board.length||y<0|| y>=board[0].length ||visited[x][y] || board[x][y]!=word.charAt(idx)){
            return false;
        }
        
        visited[x][y] = true;
        boolean result = false;
        for(int[] dir : directions){
            boolean flag = dfs(board, visited, word, x+dir[0], y+dir[1], idx+1);
            if (flag) {
                result = true;
                break;
            }
        }
        visited[x][y] = false;
        return result;
}
}