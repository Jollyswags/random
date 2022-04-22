class Solution {
      
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] board = new int[8][8];
        List<List<Integer>> res = new LinkedList<>();
        
        for(int[] queenPos : queens){
            board[queenPos[0]][queenPos[1]] = 1;
        }
        
        for(int[] direction : directions){
            int row = king[0], col = king[1];
            
            while(row>=0 && row<8 && col>=0 && col<8 && board[row][col]==0){
                row += direction[0];
                col += direction[1];
            }
            
            if(row>=0 && row<8 && col>=0 && col<8){
                res.add(new LinkedList<>(Arrays.asList(new Integer[]{row, col})));
            }
        }
        
        return res;
    }
}