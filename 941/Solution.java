class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        int i;
        for(i = 1; i < A.length; i++) if(A[i] <= A[i - 1]) break;
        if(i == 1 || i == A.length) return false;
        for(; i < A.length; i++) if (A[i] >= A[i - 1]) return false;
        return true;
    }
}