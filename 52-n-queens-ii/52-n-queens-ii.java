class Solution {

public int totalNQueens(int n) {
    int count = 0;
    boolean[][] visited = new boolean[n][n];
    int ans = countPossibleSolutions(visited, 0, n);
    return ans; 
}

public int countPossibleSolutions(boolean[][] visited, int rowNum, int n){
    if(rowNum >= n){
        return 1;
    }
    int totalCount = 0;
    for(int i = 0; i < n; i++){
        if(ifPossibleMove(visited, rowNum, i, n)){
            visited[rowNum][i] = true;
            int subCount = countPossibleSolutions(visited, rowNum + 1, n);
            totalCount += subCount;
            visited[rowNum][i] = false;
        }
    }
    return totalCount;
}

public boolean ifPossibleMove(boolean[][] visited, int x, int y, int n){
    for(int i = 0; i < x; i++){
        if(visited[i][y]){
            return false;
        }
    }
    
    int a = x-1;
    int b = y-1;
    while(a >= 0 && b >= 0){
        if(visited[a][b]){
            return false;
        }
        a--;
        b--;
    }
    
    int c = x-1;
    int d = y+1;
    while(c >= 0 && d < n){
        if(visited[c][d]){
            return false;
        }
        c--;
        d++;
    }
    return true;
}
}