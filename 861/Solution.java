class Solution {
    public int matrixScore(int[][] A) {
        for(int i = 0; i < A.length; i++){
            if(A[i][0] == 0)
                inverseRow(A, i);
        }
        for(int j = 0; j < A[0].length; j++){
            int cnt = 0;
            for(int i = 0; i < A.length; i++){
                if(A[i][j] == 1)
                    cnt += 1;
            }
            if(cnt * 2 < A.length)
                inverseColumn(A, j);
        }
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            int num = 0;
            for(int j = 0; j < A[i].length; j++){
                num = (num << 1) + A[i][j];
            }
            sum += num;
        }
        return sum;
    }
    
    private void inverseRow(int[][] A, int rowIndex){
        for(int i = 0; i < A[rowIndex].length; i++){
            A[rowIndex][i] ^= 1;
        }
    }
    
    private void inverseColumn(int[][] A, int columnIndex){
        for(int i = 0; i < A.length; i++){
            A[i][columnIndex] ^= 1;
        }
    }
    
}