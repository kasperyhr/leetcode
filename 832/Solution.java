class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] ret = new int[A.length][A.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                ret[i][j] = A[i][A.length - j - 1] ^ 1;
            }
        }
        return ret;
    }
}