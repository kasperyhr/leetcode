class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean column = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0 || j == 0){
                        if(i == 0){
                            row = true;
                        } else {
                            matrix[i][0] = 0;
                        }
                        if(j == 0){
                            column = true;
                        } else {
                            matrix[0][j] = 0;
                        }
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;                        
                    }
                }
            }
        }
        // p(matrix);
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(matrix[i][0] == 0 && i != 0 || matrix[0][j] == 0 && j != 0){
                    matrix[i][j] = 0;
                }
                if(i == 0 && row){
                    matrix[i][j] = 0;
                }
                if(j == 0 && column){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    private void p(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();    
        }
    }
}