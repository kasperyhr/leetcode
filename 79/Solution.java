class Solution {
    static final char MASK_CHAR = ' ';
    public boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(dfs(board, word, M, N, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int M, int N, int i, int j, int len){
        if(len >= word.length())
            return true;
        if(i < 0 || i >= M)
            return false;
        if(j < 0 || j >= N)
            return false;
        if(word.charAt(len) != board[i][j])
            return false;
        char c = board[i][j];
        board[i][j] = MASK_CHAR;
        boolean flag = dfs(board, word, M, N, i - 1,   j  , len + 1)
                    || dfs(board, word, M, N, i + 1,   j  , len + 1)
                    || dfs(board, word, M, N,   i  , j + 1, len + 1)
                    || dfs(board, word, M, N,   i  , j - 1, len + 1);
        board[i][j] = c;
        return flag;
    }
}
