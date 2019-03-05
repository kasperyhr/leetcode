class Solution {
    public int numRookCaptures(char[][] board) {
        int i = 0;
        int j = 0;
        search:
            for(i = 0; i < board.length; i++){
                for(j = 0; j < board[0].length; j++){
                    if(board[i][j] == 'R') break search;
                }
            }
        int ret = 0;
        ret += can(board, i + 1, j, 1, 0);
        ret += can(board, i - 1, j, -1, 0);
        ret += can(board, i, j + 1, 0, 1);
        ret += can(board, i, j - 1, 0, -1);
        return ret;
    }
    
    private int can(char[][] board, int i, int j, int directionI, int directionJ){
        if(i < 0 || i >= board.length)
            return 0;
        if(j < 0 || j >= board[0].length)
            return 0;
        if(board[i][j] == '.')
            return can(board, i + directionI, j + directionJ, directionI, directionJ);
        if(Character.isLowerCase(board[i][j]))
            return 1;
        return 0;
    }
}