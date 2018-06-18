class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        for(int i = 0; i <= grid.length - 3; i++){
            for(int j = 0; j <= grid[0].length - 3; j++){
                int[][] matrix = new int[3][3];
                for(int a = 0; a < 3; a++){
                    for(int b = 0; b < 3; b++){
                        matrix[a][b] = grid[i + a][j + b];
                    }
                }
                if(isOne2Nine(matrix) && isSum15(matrix))
                    cnt += 1;
            }
        }
        return cnt;
    }
    
    public static boolean isOne2Nine(int[][] grid){
        boolean[] flag = new boolean[9];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j] >= 1 && grid[i][j] <= 9 && !flag[grid[i][j] - 1])
                    flag[grid[i][j] - 1] = true;
                else
                    return false;
            }
        }
        return true;
    }
    
    public static boolean isSum15(int[][] grid){
        for(int i = 0; i < 3; i++){
            if(grid[i][0] + grid[i][1] + grid[i][2] != 15)
                return false;
            if(grid[0][i] + grid[1][i] + grid[2][i] != 15)
                return false;
        }
        if(grid[0][0] + grid[1][1] + grid[2][2] != 15)
            return false;
        if(grid[2][0] + grid[1][1] + grid[0][2] != 15)
            return false;
        return true;
    }
}