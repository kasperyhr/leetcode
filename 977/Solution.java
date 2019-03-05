class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ret = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for(int i = A.length - 1; i >= 0; i--){
            ret[i] = (Math.abs(A[left]) > Math.abs(A[right]))? (A[left] * A[left++]): (A[right] * A[right--]);
        }
        return ret;
    }
}