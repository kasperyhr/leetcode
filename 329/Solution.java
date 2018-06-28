class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] cnt = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(max, dfs(matrix, i, j, cnt));
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cnt){
        if(i < 0 || i >= matrix.length)
            return 0;
        if(j < 0 || j >= matrix[0].length)
            return 0;
        return 1 + Math.max( Math.max(dfs(matrix, i + 1, j, cnt, matrix[i][j]),
                                     dfs(matrix, i - 1, j, cnt, matrix[i][j])),
                           Math.max(dfs(matrix, i, j - 1, cnt, matrix[i][j]),
                                   dfs(matrix, i, j + 1, cnt, matrix[i][j]))
                           );
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cnt, int val){
        if(i < 0 || i >= matrix.length)
            return 0;
        if(j < 0 || j >= matrix[0].length)
            return 0;
        if(matrix[i][j] <= val)
            return 0;
        if(cnt[i][j] != 0)
            return cnt[i][j];
        cnt[i][j] = 1 + Math.max( Math.max(dfs(matrix, i + 1, j, cnt, matrix[i][j]),
                                     dfs(matrix, i - 1, j, cnt, matrix[i][j])),
                           Math.max(dfs(matrix, i, j - 1, cnt, matrix[i][j]),
                                   dfs(matrix, i, j + 1, cnt, matrix[i][j]))
                           );
        return cnt[i][j];
    }
}