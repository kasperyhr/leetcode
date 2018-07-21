class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n > 10)
            return 0;
        if(n == 0)
            return 1;
        int[] dp = new int[n + 1];
        dp[n] = 10;
        int ret = 9;
        n = n - 1;
        int m = 9;
        while(n > 0){
            ret *= m;
            dp[n] = dp[n + 1] + ret;
            m -= 1;
            n -= 1;
        }
        return dp[1];
    }
}