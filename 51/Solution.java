class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] arr = new int[n][n];
        List<List<String>> ret = new LinkedList();
        dfs(0, arr, n, ret);
        return ret;
    }
    
    private void dfs(int rowIdx, int[][] arr, int n, List<List<String>> ret){
        if(rowIdx == n){
            process_solution(arr, n, ret);
            return;
        }
        int cnt = 0;
        for(int i = 0; i < n; i ++){
            if(valid(arr, rowIdx, i, n)){
                arr[rowIdx][i] = 1;
                dfs(rowIdx + 1, arr, n, ret);
                arr[rowIdx][i] = 0;
            }
        }
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
    
    private void process_solution(int[][] arr, int n, List<List<String>> ret){
        List<String> new_list = new LinkedList();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            new_list.add(sb.toString());
        }
        ret.add(new_list);
    }
}