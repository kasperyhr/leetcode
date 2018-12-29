class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int dp = 0;
        int sum = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                dp++;
                sum += dp;
            } else dp = 0;
        }
        return sum;
    }
}