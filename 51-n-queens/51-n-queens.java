class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(n,0,new HashSet<>(),new HashSet<>(),new HashSet<>(),res,new ArrayList<>());
        return res;
    }
    
    void backtrack(int n,int row,Set<Integer>colSet,Set<Integer>diagSet,Set<Integer>antiDiagSet,List<List<String>> res,List<Integer> path) {
        if(row == n){
            res.add(construct(n,path));
            return;
        }
        
        for(int col=0;col<n;col++){
            
            int diag = row - col;
            int antiDiag = row + col;
            if(colSet.contains(col)|| diagSet.contains(diag)|| antiDiagSet.contains(antiDiag))
                continue;
            
            colSet.add(col);
            diagSet.add(diag);
            antiDiagSet.add(antiDiag);
            path.add(col);
            
            backtrack(n,row+1,colSet,diagSet,antiDiagSet,res,path);
            
            colSet.remove(col);
            diagSet.remove(diag);
            antiDiagSet.remove(antiDiag);
            path.remove(path.size()-1);
        }
    }
    
    private List<String> construct(int n,List<Integer> path) {

        List<String> row = new ArrayList<>();
        for (int col:path){
            StringBuilder s = new StringBuilder();
            for(int i=0;i<n;i++) s.append('.');
            s.setCharAt(col,'Q');
            row.add(s.toString());
        }
        return row;
    }
}