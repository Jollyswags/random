class Solution {
  public void gameOfLife(int[][] board) {
        int h = board.length, w = board[0].length;
		//for each living cell, add itself to its neighbors
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (board[i][j] > 0) {
                    for (int k = (i == 0 ? i : i - 1); k <= (i == h - 1 ? i : i + 1); k++) 
                        for (int l = (j == 0 ? j : j - 1); l <= (j == w - 1 ? j : j + 1); l++)
                            if (k != i || l != j) {
                                if (board[k][l] > 0) board[k][l]++;
                                else board[k][l]--;
                            }
                }
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                //if not positive, value is 0 minus # of living neighbors.
                if (board[i][j] < 1) {      
                    if (board[i][j] == -3) 
                        board[i][j] = 1;
                    else 
                        board[i][j] = 0;
                }
                //otherwise, value is 1 plus # of living neighbors.
                else {
                    if (board[i][j] != 4 && board[i][j] != 3)
                        board[i][j] = 0;
                    else 
                        board[i][j] = 1;
                }
            }
    }
}