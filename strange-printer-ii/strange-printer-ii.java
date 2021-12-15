class Solution {
    class ColorObj {
        int c;
        int left = 60;
        int top = 60;
        int right = 0;
        int bottom = 0;
        public ColorObj(int c) {
            this.c = c;
        }
    }
    public boolean isPrintable(int[][] targetGrid) {
        Set<Integer> colors = new HashSet<>();
        for (int i=0; i<targetGrid.length; i++){
            for (int j=0; j<targetGrid[0].length; j++) {
                colors.add(targetGrid[i][j]);
            }
        }
        while (colors.size() > 1) {
            Set<ColorObj> candidates = findColorCandidates(targetGrid, colors);
            if (candidates.isEmpty()) return false;
            for (ColorObj candidate : candidates) {
                colors.remove(candidate.c);
                removeColor(targetGrid, candidate);
            }
        }
        return true;
    }
    /** 
     * Find all the color candidates at current grid which can be print in rectangle
     */
    private Set<ColorObj> findColorCandidates(int[][] grid, Set<Integer> colors){
        Map<Integer, ColorObj> map = new HashMap<>();
        // Find all the color status
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue; //0 present any number
                int c = grid[i][j];
                ColorObj colorObj = map.getOrDefault(c, new ColorObj(c));
                colorObj.left = Math.min(colorObj.left, j);
                colorObj.top = Math.min(colorObj.top, i);
                colorObj.right = Math.max(colorObj.right, j);
                colorObj.bottom = Math.max(colorObj.bottom, i);
                map.put(c, colorObj);
            }
        }
        // Verify if those color are in valid rectangle
        Set<ColorObj> candidates = new HashSet<>();
        for (ColorObj co : map.values()){
            if (isValidRect(grid, co)) {
                candidates.add(co);
            }
        }
        return candidates;
    }
    /**
     * Check if the rectangle contains only target color and 0
     */
    private boolean isValidRect(int[][] grid, ColorObj co){
        for (int i = co.top; i <= co.bottom; i++){
            for (int j = co.left;j <= co.right; j++) {
                if(grid[i][j] != 0 && grid[i][j] != co.c) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Remove target color from grid (set to 0)
     */
    private void removeColor(int[][] targetGrid, ColorObj co){
        for (int i = co.top; i <= co.bottom; i++) {
            for (int j = co.left; j <= co.right; j++) {
                targetGrid[i][j] = 0;
            }
        }
    }
}