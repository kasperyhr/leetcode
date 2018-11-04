class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] ret = new int[A.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(A[i] == B[j]){
                    ret[i] = j;
                    B[j] = -1;
                    break;
                }
            }
        }
        return ret;
    }
}