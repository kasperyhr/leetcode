class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = A[0];
        int min = A[0];
        for(int i = 1; i < A.length; i++){
            max = Math.max(A[i], max);
            min = Math.min(A[i], min);
        }
        int ret = Math.max(0, max - min - 2 * K);
        return ret;
    }
}