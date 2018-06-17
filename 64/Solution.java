class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[m][n];
        newGrid[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            newGrid[i][0] = newGrid[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++){
            newGrid[0][i] = newGrid[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                newGrid[i][j] = Math.min(newGrid[i - 1][j], newGrid[i][j - 1]) + grid[i][j];
            }
        }
        return newGrid[m - 1][n - 1];
    }
}