class Solution {
    public void solveSudoku(char[][] board) {
        bt(board, 0);
    }
    
    private boolean bt(char[][] board, int index){
        if(index == 81)
            return true;
        int i = index / 9;
        int j = index % 9;
        if(board[i][j] != '.')
            return bt(board, index + 1);
        for(char c = '1'; c <= '9'; c++){
            board[i][j] = c;
            if(valid(board, i, j) && bt(board, index + 1))
                return true;
        }
        board[i][j] = '.';
        return false;
    }
    
    private boolean valid(char[][] board, int i, int j){
        for(int k = 0; k < 9; k ++){
            if(board[i][j] == board[i][k] && j != k)
                return false;
            if(board[i][j] == board[k][j] && i != k)
                return false;
            if(board[i][j] == board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] && (i != (i / 3) * 3 + k / 3 || j != (j / 3) * 3 + k % 3))
                return false;
        }
        return true;
    }
}