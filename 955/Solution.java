class Solution {
    public int minDeletionSize(String[] A) {
        int cnt = 0;
        boolean[] arr = new boolean[A.length];
        for(int i = 0; i < A[0].length(); i++){
            String s = A[0];
            boolean[] curr = new boolean[A.length];
            boolean breakflag = false;
            for(int j = 1; j < A.length; j++){
                if(arr[j]){
                    s = A[j];
                    continue;
                }
                if(s.charAt(i) > A[j].charAt(i)){
                    cnt ++;
                    breakflag = true;
                    break;
                }
                if(s.charAt(i) < A[j].charAt(i))
                    curr[j] = true;
                s = A[j];
            }
            if(!breakflag){
                for(int j = 0; j < A.length; j++){
                    if(curr[j])
                        arr[j] = true;
                }
            }
        }
        return cnt;
    }
}