class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
    
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length)
            return;
        if(j < 0 || j >= grid[0].length)
            return;
        if(grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}