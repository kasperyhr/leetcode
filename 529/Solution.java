class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        int M = board.length;
        int N = board[0].length;
        dfs(board, x, y, M, N);
        return board;
    }
    
    private void dfs(char[][] board, int x, int y, int M, int N){
        if(x < 0 || x >= M)
            return;
        if(y < 0 || y >= N)
            return;
        int cnt = 0;
        if(board[x][y] != 'E')
            return;
        if(x > 0 && board[x - 1][y] == 'M') cnt++;
        if(x > 0 && y > 0 && board[x - 1][y - 1] == 'M') cnt++;
        if(x > 0 && y < N - 1 && board[x - 1][y + 1] == 'M') cnt++;
        if(y > 0 && board[x][y - 1] == 'M') cnt++;
        if(y < N - 1 && board[x][y + 1] == 'M') cnt++;        
        if(x < M - 1 && board[x + 1][y] == 'M') cnt++;
        if(x < M - 1 && y > 0 && board[x + 1][y - 1] == 'M') cnt++;
        if(x < M - 1 && y < N - 1 && board[x + 1][y + 1] == 'M') cnt++;
        if(cnt > 0){
            board[x][y] = (char)('0' + cnt);
            return;
        }
        board[x][y] = 'B';
        dfs(board, x - 1, y, M, N);
        dfs(board, x + 1, y, M, N);
        dfs(board, x - 1, y - 1, M, N);
        dfs(board, x, y - 1, M, N);
        dfs(board, x + 1, y - 1, M, N);
        dfs(board, x - 1, y + 1, M, N);
        dfs(board, x, y + 1, M, N);
        dfs(board, x + 1, y + 1, M, N);
    }
}