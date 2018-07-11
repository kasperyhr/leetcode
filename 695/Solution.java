class Solution {
    public int maxAreaOfIsland(int[][] grid){
        int max = 0;
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length)
            return 0;
        if(j < 0 || j >= grid[0].length)
            return 0;
        if(grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int ret = 1;
        ret += dfs(grid, i + 1, j);
        ret += dfs(grid, i - 1, j);
        ret += dfs(grid, i, j + 1);
        ret += dfs(grid, i, j - 1);
        return ret;
    }
}