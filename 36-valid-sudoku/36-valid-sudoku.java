class Solution {
    public boolean isValidSudoku(char[][] board) {
         int n =board.length;
        // Checking Duplicates in rows
        for(int i=0;i<n;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[i][j]=='.')continue;
                if(set.contains(board[i][j])){
                    return false;
                }else{
                    set.add(board[i][j]);
                }
            }
        }
        // Checking Duplicates in cols
         for(int i=0;i<n;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[j][i]=='.')continue;
                if(set.contains(board[j][i])){
                    return false;
                }else{
                    set.add(board[j][i]);
                }
            }
        }
        // For each 3 x 3 sub-boxes we have separate hashset
        HashSet<Character> set[] = new HashSet[9];
        for(int i=0;i<n;i++)
            set[i]= new HashSet<Character>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.')continue;
                int index = 3*(i/3)+(j/3);
                if(set[index].contains(board[i][j])){
                    return false;
                }else{
                    set[index].add(board[i][j]);
                }
            }
        }
        return true;
    }
}