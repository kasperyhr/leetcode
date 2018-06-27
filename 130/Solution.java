class Solution {
    public void solve(char[][] board) {
        if(board.length == 0)
            return;
        if(board[0].length == 0)
            return;
        for(int i = 0; i < board.length; i++){
            dfs(board, i, 0, 'O', '*');
            dfs(board, i, board[0].length - 1, 'O', '*');
        }
        for(int j = 1; j < board[0].length - 1; j++){
            dfs(board, 0, j, 'O', '*');
            dfs(board, board.length - 1, j, 'O', '*');
        }
        
        for(int i = 1; i < board.length - 1; i++){
            for(int j = 1; j < board[0].length - 1; j++){
                dfs(board, i, j, 'O', 'X');
            }
        }
        
        for(int i = 0; i < board.length; i++){
            dfs(board, i, 0, '*', 'O');
            dfs(board, i, board[0].length - 1, '*', 'O');
        }
        for(int j = 1; j < board[0].length - 1; j++){
            dfs(board, 0, j, '*', 'O');
            dfs(board, board.length - 1, j, '*', 'O');
        }    
    }
    
    private void dfs(char[][] grid, int i, int j, char src, char dst){
        if(i < 0 || i >= grid.length)
            return;
        if(j < 0 || j >= grid[0].length)
            return;
        if(grid[i][j] != src)
            return;
        
        grid[i][j] = dst;
        dfs(grid, i + 1, j, src, dst);
        dfs(grid, i - 1, j, src, dst);
        dfs(grid, i, j + 1, src, dst);
        dfs(grid, i, j - 1, src, dst);
    
    }
}