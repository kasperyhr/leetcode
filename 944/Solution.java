class Solution {
    public int minDeletionSize(String[] A) {
        if(A.length == 0 || A[0].length() == 0)
            return 0;
        int ret = 0;
        for(int i = 0; i < A[0].length(); i++){
            char c = A[0].charAt(i);
            for(int j = 1; j < A.length; j++){
                char d = A[j].charAt(i);
                if(d < c){
                    ret ++;
                    break;
                }
                c = d;
            }
        }
        return ret;
    }
}