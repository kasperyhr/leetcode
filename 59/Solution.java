class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        right(ret, 0, 0);
        return ret;
    }
    
    public static void right(int[][] matrix, int wall, int num) {
        for(int i = wall; i < matrix[0].length - wall; i++){
            matrix[wall][i] = ++num;
        }
        down(matrix, wall, num);
    }
    
    public static void down(int[][] matrix, int wall, int num) {
        if(matrix.length <= wall * 2 + 1)
            return;
        for(int i = wall + 1; i < matrix.length - wall; i++){
            matrix[i][matrix[0].length - 1 - wall] = ++num;
        }
        left(matrix, wall, num);
    }
    
    public static void left(int[][] matrix, int wall, int num) {
        for(int i = matrix[0].length - 2 - wall; i >= wall ; i--){
            matrix[matrix.length - 1 - wall][i] = ++num;
        }
        up(matrix, wall, num);
    }
    
    public static void up(int[][] matrix, int wall, int num) {
        if(matrix.length <= wall * 2 + 2)
            return;
        for(int i = matrix.length - 2 - wall; i > wall; i--){
            matrix[i][wall] = ++num;
        }
        right(matrix, wall + 1, num);
    }
}