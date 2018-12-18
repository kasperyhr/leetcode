class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        for(i = 1; i < A.length; i++){
            if(A[i - 1] > A[i])
                return i - 1;
        }
        return 0;
    }
}