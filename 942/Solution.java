class Solution {
    public int[] diStringMatch(String S) {
        int low = 0;
        int high = S.length();
        int[] ret = new int[high + 1];
        boolean isHigh = false;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == 'I'){
                isHigh = true;
                ret[i] = low++;
            } else {
                isHigh = false;
                ret[i] = high--;
            }
        }
        ret[S.length()] = isHigh?high:low;
        return ret;
    }
}