class Solution {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int mid = (A.length - 1) / 2;
        if(A[mid] == A[mid + 1])
            return A[mid];
        else if (A[mid] == A[mid - 1])
            return A[mid];
        else
            return A[mid + 1];
    }
}