class Solution {
    public int totalNQueens(int n) {
        int[][] arr = new int[n][n];
        return dfs(0, arr, n);
    }
    
    private int dfs(int rowIdx, int[][] arr, int n){
        if(rowIdx == n)
            return 1;
        int cnt = 0;
        for(int i = 0; i < n; i ++){
            if(valid(arr, rowIdx, i, n)){
                arr[rowIdx][i] = 1;
                cnt += dfs(rowIdx + 1, arr, n);
                arr[rowIdx][i] = 0;
            }
        }
        return cnt;
    }
    
    private boolean valid(int[][] arr, int rowIdx, int colIdx, int n){
        int sum1 = 0;
        for(int i = 0; i < rowIdx; i++){
            if(arr[i][colIdx] == 1)
                return false;
            if(colIdx + (rowIdx - i) < n && arr[i][colIdx + (rowIdx - i)] == 1)
                return false;
            if(colIdx - (rowIdx - i) >= 0 && arr[i][colIdx - (rowIdx - i)] == 1)
                return false;
        }
        return true;
    }
}