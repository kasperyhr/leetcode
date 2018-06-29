class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] bd = new int[9][9];
        transform(board, bd);
        int[][][] idx = new int[9][3][3];
        divide(bd, idx);
        // p(bd);
        // p(idx);
        return valid(idx) && valid2(idx);
    }
    
    private void transform(char[][] board, int[][] bd){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.')
                    bd[i][j] = board[i][j] - '0';
            }
        }
    }
    
    private void divide(int[][] board, int[][][] idx){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int i1 = i % 3;
                int j1 = j % 3;
                int grp = (i / 3) * 3 + (j / 3);
                idx[grp][i1][j1] = board[i][j];
            }
        }
    }
    
    private boolean valid(int[][][] idx){
        for(int k = 0; k < 9; k++){
            boolean[] f = new boolean[9];
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(idx[k][i][j] != 0){
                        if(f[idx[k][i][j] - 1])
                            return false;
                        else
                            f[idx[k][i][j] - 1] = true;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean valid2(int[][][] idx){
        for(int i = 0; i < 9; i++){
            boolean[] f1 = new boolean[9];
            boolean[] f2 = new boolean[9];
            for(int j = 0; j < 9; j++){
                int i1 = i % 3;
                int j1 = j % 3;
                int grp1 = (i / 3) * 3 + (j / 3);
                if(idx[grp1][i1][j1] != 0){
                    if(f1[idx[grp1][i1][j1] -1])
                        return false;
                    else
                        f1[idx[grp1][i1][j1] -1] = true;
                }
                int i2 = j1;
                int j2 = i1;
                int grp2 = (j / 3) * 3 + (i / 3);
                if(idx[grp2][i2][j2] != 0){
                    if(f2[idx[grp2][i2][j2] -1])
                        return false;
                    else
                        f2[idx[grp2][i2][j2] -1] = true;
                } 
            }
        }
        return true;
    }
    
    private void p(int[][] ret){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private void p(int[][][] idx){
        for(int grp = 0; grp < 9; grp++){
            System.out.println("grp" + grp + ":");
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    System.out.print(idx[grp][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}