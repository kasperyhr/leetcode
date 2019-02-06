class Solution {
    public int maxA(int N) {
        if(N == 0)
            return 0;
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++){
            dp[i] = i;
            for(int j = 1; j <= i - 3; j++){
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }
}