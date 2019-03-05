class Solution {
    public boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean dec = true;
        for(int i = 1; i < A.length && (inc || dec); i++){
            if(A[i] > A[i - 1]) dec = false;
            if(A[i] < A[i - 1]) inc = false;
        }
        return inc || dec;
    }
}