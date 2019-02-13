class Solution {
    public int consecutiveNumbersSum(int N) {
        // N = ((x + 1) + .. + (x + k))
        // 2 * N = k(2 * x + k + 1) 
        // x >= 0, k >= 1
        // k < (2 * x + k + 1)
        // k and (2 * x + k + 1) must be one even one odd
        int ret = 0;
        long k = 1;
        long n = N;
        while(k * k <= n * 2){
            if((2 * n) % k != 0 || (((2 * n / k) ^ k) & 1) == 0){
                k++;
                continue;
            }
            long val = (2 * n / k);
            if(val - k - 1 >= 0) ret++;
            k++;
        }
        return ret;
    }
}