class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] ret = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                fill(ret, M, i, j, m, n);
            }
        }
        return ret;
    }
    
    private void fill(int[][] ret, int[][] M, int i, int j, int m, int n){
        int val = 0;
        int cnt = 0;
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                if(valid(i + x, j + y, m, n)){
                    val += M[i + x][j + y];
                    cnt++;
                }
            }
        }
        ret[i][j] = val / cnt;
    }
    
    private boolean valid(int i, int j, int m, int n){
        if(i < 0 || i >= m) return false;
        if(j < 0 || j >= n) return false;
        return true;
    }
}