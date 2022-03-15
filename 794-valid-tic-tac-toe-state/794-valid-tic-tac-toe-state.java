class Solution {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        int n = board.length;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag1 = 0;
        int diag2 = 0;
        int turnsDiff = 0;
        boolean xWin = false;
        boolean oWin = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c == ' ') {
                    continue;
                }
                int val = c == 'X' ? 1 : -1;
                turnsDiff += val;
                rows[i] += val;
                cols[j] += val;
                if (i == j) {
                    diag1 += val;
                }
                if (i + j == n - 1) {
                    diag2 += val;
                }
                if (rows[i] == n || cols[j] == n || diag1 == n || diag2 == n) {
                    if (oWin) {
                        return false;
                    }
                    xWin = true;
                }
                if (rows[i] == -n || cols[j] == -n || diag1 == -n || diag2 == -n) {
                    if (xWin) {
                        return false;
                    }
                    oWin = true;
                }
            }
        }

        if (turnsDiff < 0 || turnsDiff > 1) {
            return false;
        }
        if ((turnsDiff == 0 && xWin) || (turnsDiff == 1 && oWin)) {
            return false;
        }
        return true;
    }
}