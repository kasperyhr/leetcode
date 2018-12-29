class Solution {
    public int[][] candyCrush(int[][] board) {
        // p(board);
        //highlight
        boolean flag = false;
        int M = board.length, N = board[0].length;
        for(int i = 0; i < M; i++){
            for(int j = 0; j + 2 < N; j++){
                int v = Math.abs(board[i][j]);
                if(v > 0 && Math.abs(board[i][j]) == Math.abs(board[i][j + 1]) && Math.abs(board[i][j]) == Math.abs(board[i][j + 2])){
                    flag = true;
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                }
            }
        }
        for(int i = 0; i + 2 < M; i++){
            for(int j = 0; j < N; j++){
                int v = Math.abs(board[i][j]);
                if(v > 0 && Math.abs(board[i][j]) == Math.abs(board[i + 1][j]) && Math.abs(board[i][j]) == Math.abs(board[i + 2][j])){
                    flag = true;
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                }
            }
        }
        
        //fall off
        for(int j = 0; j < N; j++){
            int curr = M - 1;
            for(int i = M - 1; i >= 0; i--) if(board[i][j] > 0) board[curr--][j] = board[i][j];
            while(curr >= 0) board[curr--][j] = 0;
        }
        return flag ? candyCrush(board) : board;
    }
    
    private void p(int[][] b){
        System.out.println("-------");
        System.out.println("STATUS:");
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[i].length; j++) System.out.print(b[i][j] + " ");
            System.out.println();
        }
        System.out.println("-------");
    }
}