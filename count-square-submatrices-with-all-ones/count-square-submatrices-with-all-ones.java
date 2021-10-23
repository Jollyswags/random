class Solution {
    public int countSquares(int[][] matrix) {
        int i,j;
        int c=0;
        for(i=0;i<matrix.length;i++)
            for(j=0;j<matrix[0].length;j++)
        {
                if(matrix[i][j]==0)
                    continue;
                if(i>0 && j>0)
                {
                    matrix[i][j]=Math.min(Math.min(matrix[i-1][j],matrix[i][j-1]),matrix[i-1][j-1])+1;
                }
            
        }
         for(i=0;i<matrix.length;i++)
            for(j=0;j<matrix[0].length;j++)
                c+=matrix[i][j];
        
        return c;     
        
            
    }
}