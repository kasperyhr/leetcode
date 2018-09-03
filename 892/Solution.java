class Solution {
    public int surfaceArea(int[][] grid) {
        int ret = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > 0)
                    ret += 2 + 4 * grid[i][j];
                if(i > 0)
                    ret -= 2 * Math.min(grid[i][j], grid[i - 1][j]);
                if(j > 0)
                    ret -= 2 * Math.min(grid[i][j], grid[i][j - 1]);
                
            }
        }
        return ret;
    }
}