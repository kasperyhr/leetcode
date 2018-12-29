class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        return lower(matrix) && upper(matrix);
    }
    
    private boolean lower(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            int val = matrix[i][0];
            for(int j = 1; i + j < matrix.length && j < matrix[0].length; j++) if(val != matrix[i + j][j]) return false;
        }
        return true;
    }
    
    private boolean upper(int[][] matrix){
        for(int i = 1; i < matrix[0].length; i++){
            int val = matrix[0][i];
            for(int j = 1; j < matrix.length && i + j < matrix[0].length; j++) if(val != matrix[j][i + j]) return false;
        }
        return true;
    }
}