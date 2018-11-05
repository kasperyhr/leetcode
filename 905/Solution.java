class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] ret = new int[A.length];
        int even = 0;
        int odd = A.length - 1;
        for(int i = 0; i < A.length; i++){
            if((A[i] & 1) == 0)
                ret[even++] = A[i];
            else
                ret[odd--] = A[i];
        }
        return ret;
    }
}