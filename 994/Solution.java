class Solution {
    public int orangesRotting(int[][] grid) {
        boolean updated = false;
        boolean contains1 = false;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) contains1 = true;
                if(grid[i][j] == 2) updated = update(grid, i, j) || updated;
            }
        }
        if(!updated && !contains1) return 0;
        if(!updated && contains1) return -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = (grid[i][j] == -1) ? 2 : grid[i][j];
            }
        }
        // p(grid);
        int val = orangesRotting(grid);
        return (val == -1) ? -1 : (val + 1);
    }
    
    private void p(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private boolean update(int[][] grid, int i, int j){
        boolean ret = false;
        if(i > 0 && grid[i - 1][j] == 1){
            ret = true;
            grid[i - 1][j] = -1;
        }
        if(j > 0 && grid[i][j - 1] == 1){
            ret = true;
            grid[i][j - 1] = -1;
        }
        if(i < grid.length - 1 && grid[i + 1][j] == 1){
            ret = true;
            grid[i + 1][j] = -1;
        }
        if(j < grid[0].length - 1 && grid[i][j + 1] == 1){
            ret = true;
            grid[i][j + 1] = -1;
        }
        return ret;
    }
}