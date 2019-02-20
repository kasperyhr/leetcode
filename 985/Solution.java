class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ret = new int[queries.length];
        int sum = 0;
        for(int i = 0; i < A.length; i++) if((A[i] & 1) == 0) sum += A[i];
        for(int i = 0; i < queries.length; i++){
            if((A[queries[i][1]] & 1) == 0) sum -= A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];
            if((A[queries[i][1]] & 1) == 0) sum += A[queries[i][1]];
            ret[i] = sum;
        }
        return ret;
    }
}