class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ret = 0;
        int[] top = new int[grid.length];
        int[] left = new int[grid.length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > top[j])
                    top[j] = grid[i][j];
                if(grid[i][j] > left[i])
                    left[i] = grid[i][j];
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                ret += Math.min(top[j], left[i]) - grid[i][j];
            }
        }
        return ret;
    }
}