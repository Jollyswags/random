class Solution {
      public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList();
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        
        for(int i = 0; i < col; i++)
        {
            validFlow(heights, pacific,Integer.MIN_VALUE, 0, i);
            validFlow(heights, atlantic, Integer.MIN_VALUE, row-1,i);
        }
        for(int i = 0; i < row; i++)
        {
            validFlow(heights, pacific, Integer.MIN_VALUE, i, 0);
            validFlow(heights, atlantic, Integer.MIN_VALUE, i, col-1);
        }
        for(int i = 0;i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    List<Integer> Index = new ArrayList();
                    Index.add(i);
                    Index.add(j);
                    ans.add(Index);
                }  
            }
        }
        return ans;
    }
    
    private void validFlow(int[][] heights,boolean[][] visited,int altitude,int i,int j)
    {
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j] || altitude > heights[i][j])
            return;
        
        visited[i][j] = true;
        validFlow(heights,visited,heights[i][j],i + 1,j);
        validFlow(heights,visited,heights[i][j],i - 1,j);
        validFlow(heights,visited,heights[i][j],i,j - 1);
        validFlow(heights,visited,heights[i][j],i,j + 1);
    }
}