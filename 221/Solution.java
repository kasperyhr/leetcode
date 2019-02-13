class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] arr = new int[matrix[0].length + 1];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            int prev = 0;
            for(int j = 0; j < matrix[0].length; j++){
                int tmp = arr[j + 1];
                if(matrix[i][j] == '0'){
                    arr[j + 1] = 0;
                } else {
                    arr[j + 1] = Math.min(Math.min(arr[j], arr[j + 1]), prev) + 1;
                    max = Math.max(arr[j + 1], max);
                }
                prev = tmp;
                
            }
        }
        return max * max;
    }
}