class Solution {
    public void gameOfLife(int[][] board) {
        // if num is 1 means alive, 0 means dead
        // first we consider a middle state between two states
        // the positive number means the previous state is alive
        // the negative number means the previous state is dead
        // the abs of the value of the number means the sum of the numbers of neighbors are alive in the prev state and 1.
        // then we can transform this middle state to next state.
        
        // construct middle state
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int sum = aliveCount(board, i, j);
                sum += 1;
                if(board[i][j] == 0)
                    sum = 0 - sum;
                board[i][j] = sum;
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] > 0){
                    if(board[i][j] - 1 < 2 || board[i][j] - 1 > 3){
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if(board[i][j] + 1 == -3){
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    
    private int aliveCount(int[][] board, int i, int j){
        // consider board is M-by-N.
        int M = board.length;
        int N = board[0].length;
        int cnt = 0;
        // left-up
        if(i > 0 && j > 0){
            cnt += board[i - 1][j - 1] > 0 ? 1 : 0;
        }
        // up
        if(i > 0){
            cnt += board[i - 1][  j  ] > 0 ? 1 : 0;
        }
        // right-up
        if(i > 0 && j < N - 1){
            cnt += board[i - 1][j + 1] > 0 ? 1 : 0;
        }
        // left
        if(j > 0){
            cnt += board[  i  ][j - 1] > 0 ? 1 : 0;
        }
        // right
        if(j < N - 1){
            cnt += board[  i  ][j + 1] > 0 ? 1 : 0;
        }
        // down-left
        if(i < M - 1 && j > 0){
            cnt += board[i + 1][j - 1] > 0 ? 1 : 0;
        }
        // down
        if(i < M - 1){
            cnt += board[i + 1][  j  ] > 0 ? 1 : 0;
        }
        // down-right
        if(i < M - 1 && j < N - 1){
            cnt += board[i + 1][j + 1] > 0 ? 1 : 0;
        }
        return cnt;
    }
}
